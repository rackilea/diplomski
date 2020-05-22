public class MainView extends JPanel implements Observer {

    private JLabel label = new JLabel("");

    public void setVillageImg(String path) {
        // set the image
    }

    @Override
    public void update(Observable o, Object arg) {
        String path = (String)arg;
        System.out.println(path);
        setVillageImg(path);
    }
}