public class AnimationPanel extends JFXPanel {

    private Text[] nodes = new Text[1];

    public AnimationPanel() {
        super();

        Text t = new Text(10,50, "This is test");
        t.setFill(Color.RED);
        nodes[0] = t;

        final Scene scene = new Scene(new Group(nodes), 800, 600, Color.BLACK);

        this.setScene(scene);

        new AnimationTimer() {
            public int x = 0;
            @Override
            public void handle(long now) {
                for (int i=0; i<1; i++) {
                    final Node node = nodes[i];
                    node.setTranslateX(x);
                    x++;
                }
            }
        }.start();

    }
}