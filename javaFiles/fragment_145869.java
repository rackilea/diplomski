import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTable;

public class DragAndDrop {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JTable(new Object[][]{{1, 2, 3}, {4, 5, 6}},
                new Object[]{"one", "two", "three"}) {
            {
                addMouseMotionListener(new MouseAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        System.out.println("mouseDragged");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        System.out.println("mousePressed");
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        System.out.println("mouseReleased");
                    }
                });
            }
        });
        f.setVisible(true);
    }
}