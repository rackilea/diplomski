JSSH jssh = new JSSH();
final String[] commands = jssh.listOfCommand();

// Local class for feeding commands to a pipe in a background thread.
class CommandSender
implements Runnable {
    private final OutputStream target;

    IOException exception;

    CommandSender(OutputStream target) {
        this.target = Objects.requireNonNull(target);
    }

    @Override
    public void run() {
        try {
            for (String command : commands) {
                target.write(command.getBytes());
                target.write(10);   // newline
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (IOException e) {
            exception = e;
        } catch (InterruptedException e) {
            System.out.println("Interrupted, exiting prematurely.");
        }
    }
}

try (OutputStream log = new BufferedOutputStream(
    new FileOutputStream(OUTPUT_FILE))) {

    JSch jsch = new JSch();

    for (String host : jssh.listOfhost()) {
        Session session = jsch.getSession(user, host, 22);
        session.setPassword(password);
        session.setConfig(getProperties());
        session.connect(10 * 1000);

        Channel channel = session.openChannel("shell");
        channel.setOutputStream(log, true);

        try (PipedInputStream commandSource = new PipedInputStream();
             OutputStream commandSink = new PipedOutputStream(commandSource)) {

            CommandSender sender = new CommandSender(commandSink);
            Thread sendThread = new Thread(sender);
            sendThread.start();

            channel.setInputStream(commandSource);
            channel.connect(15 * 1000);

            sendThread.join();
            if (sender.exception != null) {
                throw sender.exception;
            }
        }

        channel.disconnect();
        session.disconnect();
    }
}