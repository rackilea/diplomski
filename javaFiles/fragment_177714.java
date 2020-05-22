@Override
public void actionPerformed(ActionEvent e){

    ...
    //buttons that have same picture are explode.
    startAnimation();
}


private void startAnimation()
{
    Thread t = new Thread(new Runnable()
    {
        @Override
        public void run()
        {
            runAnimation();
        }
    });
    t.start();
}

private int a;
private int b;
private int c;
private void runAnimation()
{
    Random r = new Random();
    a = r.nextInt(64);
    b = r.nextInt(64);
    c = r.nextInt(64);

    for(int i=0; i<63; i++)
    {
        final int iFinal = i;
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                doAnimationStep(iFinal);
            }
        });

        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            return;
        }
    }
}

private void doAnimationStep(int i)
{
    String s0 = buttons[i].getIcon().toString();
    String s1 = buttons[i+1].getIcon().toString();
    String s2 = buttons[i+2].getIcon().toString();
    if(s0.equals(s1) && s1.equals(s2))
    {
        //System.out.println("slm");
        if(i > 7){
            buttons[i].setIcon(buttons[i-8].getIcon());
            buttons[i+1].setIcon(buttons[i-7].getIcon());
            buttons[i+2].setIcon(buttons[i-6].getIcon());

            for(int j = i; j > 0; j=j-8){
                if(j > 7){
                    buttons[j].setIcon(buttons[j-8].getIcon());
                    buttons[j+1].setIcon(buttons[j-7].getIcon());
                    buttons[j+2].setIcon(buttons[j-6].getIcon());
                }
                else{
                    buttons[j].setIcon(buttons[a].getIcon());
                    buttons[j+1].setIcon(buttons[b].getIcon());
                    buttons[j+2].setIcon(buttons[c].getIcon());
                }

            }
        }
        else{
            buttons[i].setIcon(buttons[a].getIcon());
            buttons[i+1].setIcon(buttons[b].getIcon());
            buttons[i+2].setIcon(buttons[c].getIcon());
        }
    }
}