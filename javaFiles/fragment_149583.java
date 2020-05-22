public class Menu extends JMenuBar {

    ...
    private JMenuItem colorMode;
    ...

    public class Menu(ColorChanger colorChanger) {
         colorMode = new JMenuItem(new ColorModeAction(colorChanger, "Color Mode"));
    }
}