final TextView textView1 = tv_1;
wrongAns.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    public void onCompletion(MediaPlayer mp) {
        // reset your values here
        textView1.setText("0");
    }
});
wrongAns.start();