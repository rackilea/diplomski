public class Main {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InfoWindow infoWindow = new InfoWindow();
                infoWindow.setVisible(true);
                infoWindow.refresh("a", "b");
            }
        });
    }
}