void updateUI() {
   textbox.setText(et.elapsedTime());
}

void stop() {
   t.stop();
   textbox.setText("Total time was " + et.elapsedTime());
   et.stop;
}

void start() {
   et.start();
   t.start();
}

ElapsedTimer et;
Timer t(200, updateUI); // timer with interval 200 msec updateUI()