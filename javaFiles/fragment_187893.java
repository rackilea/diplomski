public class KeyEventDemo {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch ( ClassNotFoundException e ) {
            // TODO handle me
        } catch ( InstantiationException e ) {
            // TODO handle me
        } catch ( IllegalAccessException e ) {
            // TODO handle me
        } catch ( UnsupportedLookAndFeelException e ) {
            // TODO handle me
        }
    }
}