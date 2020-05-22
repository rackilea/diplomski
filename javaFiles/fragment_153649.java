public class CroixEtincelle extends Etincelle {

    public static final String FORME = "CROIX";

    public CroixEtincelle(double a, double b) {
        super(a, b);
    }

    public CroixEtincelle(double x, double y, Color couleur) {
        super(x, y, couleur);
    }

    @Override
    protected void peindreEtincelle(Graphics g) {
        g.drawLine((int) x - 5, (int) y, (int) x + 5, (int) y);
        g.drawLine((int) x, (int) y - 5, (int) x, (int) y + 5);
    }

}