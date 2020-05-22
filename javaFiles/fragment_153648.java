public class PointEtincelle extends Etincelle {

    public static final String FORME = "POINT";
    private int radius = 8;

    public PointEtincelle(double a, double b) {
        super(a, b);
    }

    public PointEtincelle(double x, double y, Color couleur) {
        super(x, y, couleur);
    }

    @Override
    protected void peindreEtincelle(Graphics g) {
        g.fillOval((int) x - radius / 2, (int) y - radius / 2, radius, radius);
    }
}