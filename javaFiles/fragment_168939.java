launchbutton.addActionListener(new ActionListener()
                {
                //GravitationalThread t = new GravitationalThread(9.8, (Math.PI)/4, 100, 500, 0, viewframe, rock);
                public void actionPerformed(ActionEvent e){
                    new Thread(g).start();
                    new Thread(t).start();
                }
            });