// MainApp.java

public class MainApp {
    public static void main( String [] args ) throws IOException {
        JFrame frame = new JFrame("MainApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JLabel("<html><font size='48'>Main App Running</font><html>") );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
        launchSeparateProcess();
        frame.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent e ){
                System.out.println("MainAppp finished");
            }
        });
    }
    private static void launchSeparateProcess() throws IOException {
        File f = new File("./yourjar.jar");
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", f.getAbsolutePath() );
        Process p = pb.start();
    }
}    

//-- Updater.jar
public class Updater {
    public static void main( String [] args ) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JLabel("<html><font size='78'>Updating....</font></html>"));
        frame.pack();
        frame.setVisible(true);
    }
}
//--manifest.mf
Main-Class: Updater