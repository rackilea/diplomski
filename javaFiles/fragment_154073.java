import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;

public class MenuItemSolution {
    public static void openDialog(JFrame frame){
        Action enterTypedAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Dialog: Enter was typed!");
            }
        };
        JDialog dialog = new JDialog(frame, "My dialog", true);
        JRootPane rootPane = dialog.getRootPane();
        ActionMap actionMap = rootPane.getActionMap();
        String enterTyped = "my_enter_typed_function";
        actionMap.put(enterTyped, enterTypedAction);
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);    
        // This is the point of change: I just created a KeyStroke to
        // deal with ENTER key typed instead of ENTER key released.
        // Only problem left (which doesn't matter in my use case):
        // Key typed events can occur several time when holding down the ENTER key.
        inputMap.put(KeyStroke.getKeyStroke('\n'), enterTyped);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setMinimumSize(new Dimension(260, 300));
        dialog.setResizable(true);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My App");
        JMenuItem item = new JMenuItem("My item");
        item.addActionListener((ActionEvent e) -> {
            openDialog(frame);
        });
        JMenu menu = new JMenu("My menu");
        menu.add(item);
        JMenuBar bar = new JMenuBar();
        bar.add(menu);

        // Register alt key to be caught
        Action altAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuElement[] elements = MenuSelectionManager.defaultManager().getSelectedPath();
                if(elements.length > 0){
                    MenuSelectionManager.defaultManager().clearSelectedPath();
                } else{
                    menu.doClick();
                }
            }
        };
        JRootPane rootPane = frame.getRootPane();
        ActionMap actionMap = rootPane.getActionMap();
        String altActionKey = "alt_key_for_menu";
        actionMap.put(altActionKey, altAction);
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_ALT, 0, true);
        inputMap.put(ks, altActionKey);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(bar);
        frame.setSize(350, 250);
        frame.setVisible(true);
    }
}