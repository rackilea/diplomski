public class Stars extends Pane {

    double width, height;
    private final Timeline timeline;

    public void startAnimation() {
        timeline.play();
    }

    public Stars(int width, int height){
        timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {

            private int iteration = 0;
            private final Random random = new Random();
            private final List<Rectangle> stars = new LinkedList<>();
            private final Set<Rectangle> toRemove = new HashSet<>();

            @Override
            public void handle(ActionEvent event) {
                // iteration is 0 on every 5th iteration to simulate both background threads at once
                iteration = (iteration + 1) % 5;

                final int slowing = 3;

                if (random.nextInt(slowing) == 0) { // also true in 1 of 3 cases
                    int size = random.nextInt(8);
                    Rectangle temp = new Rectangle(random.nextDouble() * Stars.this.width, -10, size, size);
                    temp.setFill(Color.BLACK);

                    this.stars.add(temp);
                    getChildren().add(temp);
                }

                Iterator<Rectangle> iter = stars.iterator();
                while (iter.hasNext()) {
                    Rectangle r = iter.next();
                    if (r.getY() > Stars.this.height / 2) {
                        // move rect list to set
                        toRemove.add(r);
                        iter.remove();
                    }
                }

                if (iteration == 0) {
                    // logic from background thread with lower frequency
                    getChildren().removeAll(toRemove);
                    toRemove.clear();
                }
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        this.width = width;
        this.height = height;
    }

}