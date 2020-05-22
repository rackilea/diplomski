JButton button = null;
Component[] components = panel.getComponents();

public void refreshBoard() {
    for (int i = 0; i < components.length; i++) {

        if (components[i] instanceof JButton) {
            button = (JButton) components[i];
            button.setIcon(<set the icon however you want. extracting from the `board[][]` or by creating new ones>));
        }

    }
}