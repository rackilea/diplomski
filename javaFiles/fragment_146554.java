else if(ATTEMPT>10)
    {
        SECONDS = 5 * (ATTEMPT - 9);` // CHANGE HERE
        System.out.println("attempt is more than 10");
        try
        {
            javax.swing.JOptionPane.showMessageDialog(null, "you can wait for now", "10 attemtp", 1);
            this.setEnabled(false);
            Timer timer = new Timer(1000, new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    System.out.println("timer started");
                    SECONDS--;                           //SECONDS is an integer =5 in class
                    jLabel6.setText("you can try again in "+SECONDS);
                    jLabel6.setVisible(true);
                    if(SECONDS==0)
                    {
                        setEnabled(true);
                        login_btn.setEnabled(true);
                        ((Timer)evt.getSource()).stop();
                        System.out.println("timer has stopped");
                    }
                }
            });
            timer.start();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }