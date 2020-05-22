import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class Test {

    public Test() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JMenuBar menuBar=new JMenuBar();

        JMenu menu = new JMenu("File");
        JMenu menu2 = new JMenu("Else");

        JMenuItem item1 = new JMenuItem("something 1");
        JMenuItem item2 = new JMenuItem("something 2");
        JMenuItem item3 = new JMenuItem("else 1");
        JMenuItem item4 = new JMenuItem("else 2");

        menu2.add(item3);
        menu2.addSeparator();//lets add that separator
        menu2.add(item4);

        menu.add(menu2);
        menu.add(item1);
        menu.addSeparator();//lets add that separator
        menu.add(item2);

        menuBar.add(menu);

        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}