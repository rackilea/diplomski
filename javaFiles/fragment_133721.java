public class Pong extends JPanel
{
    //...


    public Pong(Color backcolor, int Width, int Height)
    {
        // ...

        timer =  new javax.swing.Timer(5, new MoveListener());
        addKeyListener(new KeyWatcher());