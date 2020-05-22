public void onClick(View view) {
    score++;
    scoretv.setText(String.valueOf(score));
    //load(); <-unnecessary
    timer.cancel();
}