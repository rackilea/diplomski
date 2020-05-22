SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if(done>=x) {
                    x=x+x;
                    y++;
                    Menu.progressBar.setValue(y);

                }
            }
        });