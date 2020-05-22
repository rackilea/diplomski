public class Titlebar extends JFrame {

    private final Dimension _screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public void run(){
        this.setTitle("TitleBar"); 
        this.setSize(_screenSize);
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    } 

    public static void main(String[] args) {
        Titlebar test = new Titlebar();
        test.run();
    }
}