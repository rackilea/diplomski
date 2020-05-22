import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class TestJPopup {

    protected void initUI() {
        JFrame frame = new JFrame(TestJPopup.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem("One"));
        popupMenu.add(new JMenuItem("Two"));
        popupMenu.add(new JMenuItem("Three"));
        JList list = new JList(new String[] { "Hello", "World", "Something", "Else", "Out", "Of", "Ideas" });
        list.setComponentPopupMenu(popupMenu);
        frame.add(list);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestJPopup().initUI();
            }
        });
    }
}