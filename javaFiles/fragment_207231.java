//Handle LAUNCH action.
else if (e.getSource() == launchButton) 
{
    JFrame launchConfirmationFrame = new JFrame("Launch Confirmation");
    launchConfirmationFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    int answer;

    launchConfirmationFrame.pack();
    //downloadDateframe.setVisible(true);

        //if answer=0 its yes, if its =1 its no!
        answer = JOptionPane.showConfirmDialog(
                launchConfirmationFrame
                ,"^^^^ ARE YOU SURE YOU WOULD LIKE TO PROCEED? ^^^^"
                ,"TITLE"
                ,JOptionPane.YES_NO_OPTION);

        if(answer==0)
        {
            buttonPanel.removeAll();
            optionsFrame.repaint();
            optionsFrame.setVisible(true); // THIS HIDES THE GUI FRAME if it is set to false. 

            System.out.println("Launching YOURPROGRAM...");

            //THIS CREATES AND STARTS THE THREAD WITH YOUR PROGRAM TO BE LAUNCHED
                //More info on threads here http://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
            Thread t = new Thread(new Runnable() {
                public void run() {
                    //Turn off metal's use of bold fonts
                    UIManager.put("swing.boldMetal", Boolean.FALSE); 
                    launchYOURPROGRAM();
                }
            });

            t.start();
        }

        else if (answer==1)
        {
            optionsFrame.setVisible(false);
            optionsFrame.setVisible(true);
            System.out.println("Returning to GUI Frame...");
        }
    }'