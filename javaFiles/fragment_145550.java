public class ParallelProgress extends Application {
static class ParallelProgressBar extends ProgressBar {
    AtomicInteger myDoneCount = new AtomicInteger();
    int           myTotalCount;
    Timeline      myWhatcher = new Timeline(new KeyFrame(Duration.millis(10), e -> update()));

    public void update() {
        setProgress(1.0*myDoneCount.get()/myTotalCount);
        if (myDoneCount.get() >= myTotalCount) {
            myWhatcher.stop();
            myTotalCount = 0;
        }
    }

    public boolean isRunning() { return myTotalCount > 0; }

    public void start(int totalCount) {
        myDoneCount.set(0);
        myTotalCount = totalCount;
        setProgress(0.0);
        myWhatcher.setCycleCount(Timeline.INDEFINITE);
        myWhatcher.play();
    }

    public void add(int n) {
        myDoneCount.addAndGet(n);
    }
}

HBox testParallel(HBox box) {
    ArrayList<String> myTexts = new ArrayList<String>();

    for (int i = 1; i < 10000; i++) {
        myTexts.add("At "+System.nanoTime()+" ns");
    }

    Button runp = new Button("parallel");
    Button runs = new Button("sequential");
    ParallelProgressBar progress = new ParallelProgressBar();

    Label result = new Label("-");

    runp.setOnAction(e -> {
        if (progress.isRunning()) return;
        result.setText("...");
        progress.start(myTexts.size());

        new Thread() {
            public void run() {
                long ms = System.currentTimeMillis();
                myTexts.parallelStream().forEach(text -> {
                    progress.add(1);
                    try { Thread.sleep(1);} catch (Exception e1) { }
                });
                Platform.runLater(() -> result.setText(""+(System.currentTimeMillis()-ms)+" ms"));
            }
        }.start();
    });

    runs.setOnAction(e -> {
        if (progress.isRunning()) return;
        result.setText("...");
        progress.start(myTexts.size());
        new Thread() {
            public void run() {
                final long ms = System.currentTimeMillis();
                myTexts.forEach(text -> {
                    progress.add(1);
                    try { Thread.sleep(1);} catch (Exception e1) { }
                });
                Platform.runLater(() -> result.setText(""+(System.currentTimeMillis()-ms)+" ms"));
            }
        }.start();
    });

    box.getChildren().addAll(runp, runs, progress, result);
    return box;
}


@Override
public void start(Stage primaryStage) throws Exception {        
    primaryStage.setTitle("ProgressBar's");

    HBox box = new HBox();
    Scene scene = new Scene(box,400,80,Color.WHITE);
    primaryStage.setScene(scene);

    testParallel(box);

    primaryStage.show();   
}

public static void main(String[] args) { launch(args); }
}