public class MultiProgressTask extends Application {
    private static final int THREADS_NUM = 10;

    // this is our Task which produces a Node and track progress
    private static class MyTask extends Task<Node> {

        private final int delay = new Random().nextInt(1000) + 100;
        { System.out.println("I update progress every " + delay); }

        @Override
        protected Node call() throws Exception {
            updateProgress(0, 5);
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                Thread.sleep(delay); // imitating activity
                updateProgress(i+1, 5);
            }
            System.out.println("done");
            return new Rectangle(20, 20, Color.RED);
        }
    };

    @Override
    public void start(Stage primaryStage) {
        ProgressBar pb = new ProgressBar(0);
        pb.setMinWidth(300);

        final VBox root = new VBox();
        root.getChildren().add(pb);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

        DoubleBinding progress = null;

        for (int i = 0; i < THREADS_NUM; i++) {
            final MyTask mt = new MyTask();

            // here goes binding creation
            DoubleBinding scaledProgress = mt.progressProperty().divide(THREADS_NUM);
            if (progress == null) {
                progress = scaledProgress;
            } else {
                progress = progress.add(scaledProgress);
            }
            // here you process the result of MyTask
            mt.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

                @Override
                public void handle(WorkerStateEvent t) {
                    root.getChildren().add((Node)t.getSource().getValue());
                }
            });
            new Thread(mt).start();
        }
        pb.progressProperty().bind(progress);
    }


    public static void main(String[] args) { launch(args); }
}