public class Fusee extends Etincelle {

    private static final HashMap<String, Class<? extends Etincelle>> ETINCELLE_MAP = new HashMap<String, Class<? extends Etincelle>>() {{
        put(CroixEtincelle.FORME, CroixEtincelle.class);
        put(PointEtincelle.FORME, PointEtincelle.class);
        put(EtoileEtincelle.FORME, EtoileEtincelle.class);
    }};

    //ATTRIBUTES
    public int size;
    public long duree;
    public String forme;

    //CONSTRUCTOR
    public Fusee(double x, double y, String forme, Color couleur, int size, long duree) {
        super(x, y, couleur);
        this.size = size;
        this.forme = forme;
        this.duree = duree;
    }

    private static LinkedList<Drawable> getPattern(double xf, double yf, Color couleur, String forme, int puissEtincelles) {
        LinkedList<Drawable> liste = new LinkedList<Drawable>();

        if (ETINCELLE_MAP.containsKey(forme)) {
            Class<? extends Etincelle> clz = ETINCELLE_MAP.get(forme);

            Class[] params = new Class[]{double.class, double.class, Color.class};

            try {
                Constructor ctor = clz.getConstructor(params);

                liste.add((Drawable) ctor.newInstance(xf, yf, couleur));

                for (int k = 1; k <= puissEtincelles; k++) {
                    int mult = 10 * k;
                    liste.add((Drawable) ctor.newInstance(xf + mult, yf, couleur));
                    liste.add((Drawable) ctor.newInstance(xf - mult, yf, couleur));
                    liste.add((Drawable) ctor.newInstance(xf, yf + mult, couleur));
                    liste.add((Drawable) ctor.newInstance(xf, yf - mult, couleur));
                    liste.add((Drawable) ctor.newInstance(xf + mult, yf + mult, couleur));
                    liste.add((Drawable) ctor.newInstance(xf + mult, yf - mult, couleur));
                    liste.add((Drawable) ctor.newInstance(xf - mult, yf + mult, couleur));
                    liste.add((Drawable) ctor.newInstance(xf - mult, yf - mult, couleur));
                }

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        } else {
            System.err.printf("Forme \"%s\" is not supported\n", forme);
        }

        return liste;
    }

    @Override
    protected void peindreEtincelle(Graphics g) {

        LinkedList<Drawable> liste;

        int mult = 10 * size;

        for (int gen = 0; gen < size; gen++) {

//            clearGraphics(g, (int) x - mult, (int) y - mult, 2 * mult, 2 * mult, Color.black);

            liste = getPattern(x, y, couleur, forme, gen);

            if (gen == 0) {
                Drawable d = liste.get(0);
                d.drawOn(g);
            } else {

                for (int i = 0; i < liste.size(); i++) {
                    Drawable d = liste.get(i);
                    if (i >= 8 * (gen - 1) + 1 && i <= 8 * gen) {
                        d.drawOn(g);
                    }
                    // else {
                    //    g.setColor(Color.black);
                    //    ((Etincelle) d).peindreEtincelle(g);
                    // }
                }

                try {
                    Thread.sleep(duree);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

//        clearGraphics(g, (int) x - mult, (int) y - mult, 2 * mult, 2 * mult, Color.black);
    }

    private void clearGraphics(Graphics g, int x, int y, int width, int height, Color background) {
        Color prevColor = g.getColor();

        g.setColor(background);
        g.fillRect(x, y, width, height);

        g.setColor(prevColor);
    }
}