public class MyFrame extends JFrame {
    public MyFrame() {
       ...
       // since JDK 1.4 you do not need to use JFrame.getContentPane().add(..)
       this.add(new MyPanel());
    }
}