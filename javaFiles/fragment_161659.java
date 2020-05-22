public class MyPanel extends JPanel{

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.draw([whatever you want]);

        ...
        ...

    }
}
public class MyFrame extends JFrame{

    public MyFrame(){

    MyPanel myPanel = new MyPanel();

    myPanel.repaint();

    }

}