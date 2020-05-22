private boolean jfxIsSetup;

private void doOnJavaFXThread(Runnable pRun) throws RuntimeException {
    if (!jfxIsSetup) {
        setupJavaFX();
        jfxIsSetup = true;
    }
    final CountDownLatch countDownLatch = new CountDownLatch(1);
    Platform.runLater(() -> {
        pRun.run();
        countDownLatch.countDown();
    });

    try {
        countDownLatch.await();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

protected void setupJavaFX() throws RuntimeException {
    final CountDownLatch latch = new CountDownLatch(1);
    SwingUtilities.invokeLater(() -> {
        new JFXPanel(); // initializes JavaFX environment
        latch.countDown();
    });

    try {
        latch.await();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}


@BeforeMethod
public void init() throws IOException
{
    AtomicReference<JavafxMatchesTabView> tabView = new AtomicReference<>();
    AtomicReference<MatchesTabDisplay> tabDisplay = new AtomicReference<>();
    doOnJavaFXThread(()->{
        tabView.set(new JavafxMatchesTabView());
        tabDisplay.set(view.getDisplay());
    });
    view = tabView.get();
    display = tabDisplay.get();
}