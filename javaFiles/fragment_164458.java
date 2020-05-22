public class Window extends JFrame
{   
    private Content content;

    public Window()
    {       
        setTitle("My Window");
        setPreferredSize(new Dimension(800, 600));

        setResizable(false);
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
        pack();

        content = new Content(this);

        add(content);

        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Window();
    }
}
public class Content extends JPanel
{
    Window window = null;
    public Content(Window w)
    {
        window = w;
        System.out.println(window.getContentPane().getWidth());
    }
}