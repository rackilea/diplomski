for(int i = 0; i < panelResult.length; i++){

            //some hidden codes here...
            final JPanel panel = panelResult[i];
            panel.add(labelArrayResult);

            panel.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    panel.setBackground(Color.BLACK);
                    //the index here is the error
                    revalidate();
                    repaint();
                }

            });

        }