class AMyContainer extends JComponent
{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D)g.create();
                 // note, we are creating a graphics object here for safe painting
            LinearGradientPaint p=new LinearGradientPaint(0, 0, 0, getHeight(),new float[]{0f,1f},new Color[]{new Color(0.2498f,0.2498f,0.2498f,0.3f),new Color(0.1598f,0.1598f,0.1598f,0.8f)});
            g2.setPaint(p);
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose(); // disposing the object which we created 
    }

}

class Home extends JFrame
{
    int width=GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
    int height=GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
    public Home()
    {
        super("WiND");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(width,height);
        setBackground(new Color(0,0,0,0));
        setUndecorated(true);

        JComponent container = new AMyContainer();
        container.setLayout(new FlowLayout());
        add(container);

        JPanel p=new JPanel();
        p.setBackground(new Color(0x0D70E8));
        p.setPreferredSize(new Dimension(width,height/10));
        container.add(p);
    }



    public static void main(String[] args)
    {
        new Home().setVisible(true);

    }
}