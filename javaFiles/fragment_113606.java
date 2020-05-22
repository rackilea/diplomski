for (int i = 0; i < 3 ; i++) {
            final int currentIter = i;
            productIconLabel[i] = new JLabel("");
            productIconLabel[i].addMouseListener( new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent arg0) {
                    try {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + urlPage.get(currentIter));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });