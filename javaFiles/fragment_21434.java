catch (HttpServerErrorException hsee) {
        switch(hsee.getRawStatusCode()) {
            default:
                try {
                    hsee.printStackTrace();
                    Thread.sleep(1000);
                    return getSummonerInformationFromAccountId(accountId);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }