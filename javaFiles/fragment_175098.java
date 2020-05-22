// TODO: shut this down after you're done with it???
private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(r -> {
    Thread t = new Thread(r);
    t.setDaemon(true);
    return t;
});

@Override
public void initialize(URL location, ResourceBundle resources) {
    ...
    startTask();
}

private final Runnable updateRunnable = () -> {
    Platform.runLater(() -> {
        nameLvl.setText(list.get(count).getName());
        rollLvl.setText("Roll: " + list.get(count).getRoll());
        batchLvl.setText("Batch: " + list.get(count).getBatch());
        depLvl.setText("Department: " + list.get(count).getDepartment());
        uniLvl.setText(list.get(count).getUniversity());
        circle.setFill(new ImagePattern(new Image(list.get(count).getImagePath())));

        fd.play();
        rt.play();
        tm.play();

        count++;
        if (count >= list.size())
            count = 0;
        }
    });
};

private ScheduledFuture scheduledFuture;

private void startTask() {
    scheduledFuture = executor.scheduleWithFixedDelay(updateRunnable, 0, 10000, TimeUnit.MILLISECONDS);
}

public void playThread() {
    if (scheduledFuture == null) {
        // nothing running currently
        startTask();
    } else {
        scheduledFuture.cancel();
        scheduledFuture = null;
    }
}