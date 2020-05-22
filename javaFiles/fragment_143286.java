new Thread(){
    public void run() {
        //initiate  the bot:
        try {
            irc_bot.initiate(server, ports);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }}.start();