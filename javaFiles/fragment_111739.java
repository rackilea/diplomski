dice.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {     
            String randomNum = String.valueOf(randomNumber);

            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        Thread.sleep(6000);
                    }
                    catch(Exception ie){}

                    Position[playerTurn].setText(posi);
                }
            });
        }
    });