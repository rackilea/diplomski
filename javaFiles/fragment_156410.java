new Thread(new Runnable
{
    public void run()
    {
        for(int count = 0; count < PREROLLS; count++)
        {
            //Add your for loop logic here!

            SwingUtilities.invokeLater(new Runnable() {
                 public void run()
                 {
                       //then update you icon here. I would start with one die if I were you.
                       imgDice1 = new ImageIcon(path + dice1 + ".png");
                 }
            });
            try { Thread.sleep(100); } catch(Exception e) {}
        }
    }
}).start();