public class Server extends PircBot implements Runnable {

    private bot BotRun;
    private String channel;
    public void run() {
        String names[] = org.bestever.bebot.bot.hostbuilder.split(" ");
        ProcessBuilder pb = new ProcessBuilder(names);
        pb.redirectErrorStream(true);
        try {
            Process proc = pb.start();
            Reader reader = new InputStreamReader(proc.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String strLine = null;
            while((strLine = br.readLine()) != null) {
                // Returns UDP Initialized if the server was successfully started
                if (strLine.equalsIgnoreCase("UDP Initialized.")) {
                    BotRun.sendMessage(channel, "Server started successfully.");
                }
                // Returns Bad Hex Number if there is a problem with the WAD file
                else if (strLine.startsWith("Bad hex number")) {
                    BotRun.sendMessage(channel, "Error starting server: "+strLine);
                }
                System.out.println(strLine);
            }
            reader.close();
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Server (bot BotRun, String channel) {
        this.BotRun = BotRun;
        this.channel = channel;
    }
}