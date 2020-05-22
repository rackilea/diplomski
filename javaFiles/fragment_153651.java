public class FuseePanel extends Panel {

    //CONSTRUCTOR
    public FuseePanel() { }

    //METHOD
    @Override
    public void paint(Graphics g) {
        int w = this.getSize().width;
        int h = this.getSize().height;

        Color defaultColor = g.getColor();
        g.setColor(Color.black);
        g.fillRect(0, 0, w, h);
        g.setColor(defaultColor);

        java.util.List<Drawable> shapes = new ArrayList<Drawable>();
        shapes.add(new PointEtincelle(40, 40));
        shapes.add(new CroixEtincelle(70, 89));

        int fuseeDuree = 100;
        shapes.add(new Fusee(234, 264, PointEtincelle.FORME, Color.blue, 8, 2*fuseeDuree));
        shapes.add(new Fusee(500, 264, CroixEtincelle.FORME, Color.yellow, 20, fuseeDuree/2));
        shapes.add(new Fusee(400, 400, EtoileEtincelle.FORME, Color.red, 8, 5*fuseeDuree));

        for (Drawable d : shapes) {
            d.drawOn(g);
        }
    }

    //MAIN
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final Frame f = new Frame();
                f.setLocation(100, 100);
                f.add(new FuseePanel());
                f.setSize(1200, 700);

                f.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        f.dispose();
                        System.exit(0);
                    }
                });

                f.setVisible(true);
            }
        });
    }
}