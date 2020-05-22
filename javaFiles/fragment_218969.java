private Runnable runnableCountdown = new Runnable() {
@Override
public void run() {
    TextView tv_countdown = (TextView)dialog.findViewById(R.id.tv_countdown);

    switch(count) {
        case 0:
            startChron();
            stopCountdown();
            break;
        case 1:
            tv_countdown.setText("GO!");
            break;
        default:
            tv_countdown.setText(String.valueOf(count - 1));

            break;
    }

    count--;
    runnableCountdown.postDelayed(this, 1000);
}
};