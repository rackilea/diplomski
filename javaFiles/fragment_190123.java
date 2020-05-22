public class Mappa extends JPanel {
    //...
    public Dimension getPreferredSize() {
        return immagine == null ? new Dimension(200, 200) : new Dimension(immagine.getWidth(), immagine.getHeight());
    }
    //...
}