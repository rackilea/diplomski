import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

public class MyMouse extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        JComponent cell = (JComponent) e.getSource();
        if (cell != null) {
            Integer row = (Integer) cell.getClientProperty(MyGrid.ROW);
            Integer col = (Integer) cell.getClientProperty(MyGrid.COL);

            System.out.printf("[%d, %d]%n", row, col);
        }
    }
}