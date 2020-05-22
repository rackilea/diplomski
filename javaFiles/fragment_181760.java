import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

@SuppressWarnings("serial")
public class MenuChanger extends JPanel {
    private CreateMenu createMenu = new CreateMenu();
    private MenuChngModel model = new MenuChngModel();
    private ButtonGroup buttonGroup = new ButtonGroup();

    public MenuChanger() {
        setPreferredSize(new Dimension(400, 300));
        model.addPropertyChangeListener(MenuChngModel.PRIVILEGES, new ModelListener());

        JPanel privilegesPanel = new JPanel();
        privilegesPanel.setLayout(new GridLayout(0, 1, 5, 5));
        privilegesPanel.setBorder(BorderFactory.createTitledBorder("Privileges"));

        for (final Privileges privileges : Privileges.values()) {
            JRadioButton rBtn = new JRadioButton(privileges.toString());
            if (privileges == Privileges.REGULAR) {
                rBtn.setSelected(true);
            }
            rBtn.addActionListener(e -> {
                createMenu.setPrivileges(privileges);
            });
            buttonGroup.add(rBtn);
            privilegesPanel.add(rBtn);
        }

        add(privilegesPanel);

    }

    public CreateMenu getCreateMenu() {
        return createMenu;
    }

    private class ModelListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            Privileges privileges = (Privileges) evt.getNewValue();
            createMenu.setPrivileges(privileges);
        }
    }

    private static void createAndShowGui() {
        MenuChanger mainPanel = new MenuChanger();

        JFrame frame = new JFrame("MenuChanger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setJMenuBar(mainPanel.getCreateMenu().getMenubar());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class MenuChngModel {
    public static final String PRIVILEGES = "privileges";
    private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);
    private Privileges privileges = Privileges.REGULAR;

    public Privileges getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Privileges privileges) {
        Privileges oldValue = this.privileges;
        Privileges newValue = privileges;
        this.privileges = privileges;
        pcSupport.firePropertyChange(PRIVILEGES, oldValue, newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(name, listener);
    }

}

enum Privileges {
    REGULAR("Regular"), ADMINISTRATOR("Administrator");
    private String text;
    private Privileges(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

class CreateMenu {
    private JMenuBar menubar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu adminMenu = new JMenu("Administrator");
    private JMenuItem fileMenuItem = new JMenuItem("File Menu Item");
    private JMenuItem adminFileMenuItem = new JMenuItem("Admin File Menu Item");


    public CreateMenu() {
        fileMenu.setMnemonic(KeyEvent.VK_F);
        adminMenu.setMnemonic(KeyEvent.VK_A);

        fileMenu.add(fileMenuItem);
        fileMenu.add(adminFileMenuItem);       
        adminMenu.add(new JMenuItem("Foo 1"));
        adminMenu.add(new JMenuItem("Foo 2"));
        adminFileMenuItem.setEnabled(false);
        adminMenu.setEnabled(false);
        menubar.add(fileMenu);
        menubar.add(adminMenu);
    }

    public void setPrivileges(Privileges privileges) {
        switch (privileges) {
        case REGULAR:
            adminMenu.setEnabled(false);
            adminFileMenuItem.setEnabled(false);
            break;
        case ADMINISTRATOR:
            adminMenu.setEnabled(true);
            adminFileMenuItem.setEnabled(true);
            break;

        default:
            break;
        }
    }

    public JMenuBar getMenubar() {
        return menubar;
    }

}