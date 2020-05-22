private int i = 0; // a filed used for counting 

public void write() {

    label.setText("FIRST TIME");

    PauseTransition pause = new PauseTransition(Duration.seconds(2));
    pause.setOnFinished(event ->{
        label.setText("Value "+i++);
        if (i<=6) {
            pause.play();
        } else {
            label.setText("LAST TIME");
        }
    });
    pause.play();
}