public class MyPanel extends JPanel {
    public MyPanel()
    {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }
    String output = "test";
    String event;

    public void init()
    {
        event = "\nInitializing...";
        printOutput();
    }
    // Put all the other methods in here too

    private void printOutput()
    {
        System.out.println(event);
        output += event;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        System.out.println("Graphics Paint Method!");
        g.setColor(this.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(this.getForeground());
        g.drawString(output, 100, 100);
    }
}
public class MyFrame extends JFrame {
    MyPanel myPanel;
    public MyFrame()
    {
        super("Test frame");
        setSize(745,440); 
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanel=new MyPanel();
        add(myPanel,BorderLayout.CENTER);
    }
    public static void main(String[] args)
    {
        MyFrame f = new MyFrame();
        f.setVisible(true);
    }
}
public class MyApplet extends JApplet {
    private static final long serialVersionUID = 1L;

    MyPanel myPanel;

    @Override
    public void init()
    {
        myPanel = new MyPanel();
        getContentPane().add(myPanel,BorderLayout.CENTER);
    }
}