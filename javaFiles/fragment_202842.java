private class FloodMonitor implements Runnable {

    private final int MAXBYTES = 768;
    private int messageBuffer = 0;
    private boolean suspend = false;
    private boolean stop = false;

    @Override
    public void run() {

        while (!stop) {
            while (!suspend) {
                final MessageStructure message = out.peek();
                if (message != null) {
                    messageBuffer += message.msg.getBytes().length;
                    if (messageBuffer < MAXBYTES) {
                        out.poll().sendMessage();
                    } else {
                        suspend();

                        SwingUtilities.invokeLater(new Runnable() {

                            @Override
                            public void run() {
                                message.bot.send("ping irc.quakenet.org");
                            }
                        });

                    }
                }
            }
        }
    }

    public void resetBuffer() {
        messageBuffer = 0;
        suspend = false;
    }

    public void stop() {
        stop = true;
    }

    public void suspend() {
        suspend = true;
    }
}