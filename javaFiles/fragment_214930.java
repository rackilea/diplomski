textArea.getCaret().addChangeListener(new ChangeListener(){     //Seams to work!

            @Override
            public void stateChanged(ChangeEvent e) {

                SwingUtilities.invokeLater(new Runnable(){

                    @Override
                    public void run() {

                        //Do stuff

                    }
                });
            }
        });