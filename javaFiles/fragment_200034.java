public class ContentPane extends JPanel {

    private ButtonPane[][] buttonPanels;

    public ContentPane() {
        setLayout(new GridLayout(3, 3));
        buttonPanels = new ButtonPane[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttonPanels[row][col] = new ButtonPane();
                add(buttonPanels[row][col]);
            }
        }
    }

    public ButtonPane getButtonPaneAt(int row, int col) {
        return buttonPanels[row][col];
    }

}