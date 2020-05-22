public abstract class Etincelle implements Drawable {

    public double x, y;
    public Color couleur;

    public Etincelle(double x, double y, Color couleur) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
    }

    public Etincelle(double x, double y) {
        this(x, y, Color.red);
    }

    protected abstract void peindreEtincelle(Graphics g);

    @Override
    public void drawOn(Graphics g) {
        Color previous = g.getColor();

        g.setColor(couleur);
        peindreEtincelle(g);

        g.setColor(previous);
    }
}