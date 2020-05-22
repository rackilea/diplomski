public class guitarGame extends Applet implements ActionListener, KeyListener {

    Timer timer = new Timer (1000, this);
    int amount;

    public void init(){
        amount = 0;
        //addKeyListener(this);
        timer.setRepeats(true);
        timer.starts();
    }

    public void keyReleased(KeyEvent ae){}

    public void keyPressed(KeyEvent ae){

        repaint();
    }

    public void keyTyped(KeyEvent ae){}

    public void actionPerformed (ActionEvent ae){
        amount++;
        repaint();
    }
    public void paint (Graphics g)
    {
        // Do this or suffer increasingly bad paint artefacts
        super.paint(g);
        // This is the wrong place for this...
        //amount += 1;
        g.drawString(amount+"Seconds",400,400);
        // This is an incredibly bad idea
        //repaint();
    }
}