public class App {

    public static void main(String [] args) {
        try {

            UIManager.setLookAndFeel(new SubstanceGraphiteAquaLookAndFeel());
            UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteAquaLookAndFeel");    

        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                //Your GUI code goes here..
            }
        });

    }
}