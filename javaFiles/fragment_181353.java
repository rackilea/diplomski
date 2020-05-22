private void startGame() {
new Thread(new Runnable() {
    public void run() {
        while (isGiocoAttivo()) {
            try {
                Thread.sleep(velocitaDiGioco);
               runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    accendiBomba() 
                }
            });
            } catch (InterruptedException ex) {
            }
        }

    }
}).start();}