public class MyTableHeaderUI extends BasicTableHeaderUI {

    // UIDefaults.getUI(JComponent) will call this method via reflection
    public static ComponentUI createUI(JComponent h) {
        return new MyTableHeaderUI();
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return super.getPreferredSize(c);
    }
}