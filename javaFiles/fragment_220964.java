import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = createFrame();

        MenuItem menuItem1 = new MenuItem("getForeground", "Foreground Color");
        MenuItem menuItem2 = new MenuItem("getBackground", "Background Color");
        PopUpMenu popUpMenu = new PopUpMenu(new MenuItem[] { menuItem1, menuItem2 });
        popUpMenu.setParent(frame);

        frame.setVisible(true);
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }

}


class PopUpMenu extends JPopupMenu {

    private Container parent;

    public PopUpMenu(MenuItem[] menuItems) {
        super();
        for (MenuItem item : menuItems) {
            add(item);
        }
    }

    public Container getParentComponent() {
        // another name because I don't want to override getParent()
        // Try to rename this method to getParent to see 
        // that it will not work
        return parent;
    }

    public void setParent(Container parent) {
        this.parent = parent;
        parent.addMouseListener(new PopUpListener(this));
    }

}

class MenuItemListener extends IListener {

    protected void action(ActionEvent event) {
        Object source = event.getSource();
        if (source instanceof MenuItem) {
            MenuItem item = (MenuItem) source;
            Container parent = item.getParent();
            if (parent instanceof PopUpMenu) {
                PopUpMenu menu = (PopUpMenu) parent;
                Container container = menu.getParentComponent();
                try {
                    String name = item.getMethodName();
                    Method method = container.getClass().getMethod(name);
                    Object invoke = method.invoke(container);
                    JOptionPane.showMessageDialog(container, invoke);
                } catch (Exception e) {
                }
            }
        }
    }

}


abstract class IListener implements ActionListener {
    private boolean keyboardSensitive;

    public IListener() {
        setKeyboardSensitive(false);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if ((event.getModifiers() != 0) || isKeyboardSensitive()) {
            action(event);
        }
    }

    protected abstract void action(ActionEvent event);

    public boolean isKeyboardSensitive() {
        return keyboardSensitive;
    }

    public void setKeyboardSensitive(boolean keyboardSensitive) {
        this.keyboardSensitive = keyboardSensitive;
    }

}

class MenuItem extends JMenuItem {
    private String methodName;

    public MenuItem(String methodName, String text) {
        super(text);
        setMethodName(methodName);
        setFocusable(true);
        addActionListener(new MenuItemListener());
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

}

class PopUpListener extends MouseAdapter {
    private PopUpMenu menu;

    public PopUpListener(PopUpMenu menu) {
        setMenu(menu);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        if (event.isPopupTrigger()) {
            menu.show(event.getComponent(), event.getX(), event.getY());
        }

    }

    public void mouseReleased(MouseEvent event) {
        if (event.isPopupTrigger()) {
            menu.show(event.getComponent(), event.getX(), event.getY());
        }
    }

    public PopUpMenu getMenu() {
        return menu;
    }

    public void setMenu(PopUpMenu menu) {
        this.menu = menu;
    }

}