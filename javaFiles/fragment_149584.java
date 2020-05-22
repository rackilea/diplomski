public class ColorModeAction extends AbstractAction {

    private ColorChanger colorChanger;

    public ColorModeAction(ColorChanger colorChanger, String name) {
        super(name);

        this.colorChanger = colorChanger;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Color[] colors = { Color.CYAN, Color.BLACK, Color.WHITE, Color.GREEN };

        colorChanger.changeColor(index, Color)

    }
}