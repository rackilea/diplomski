private long mTimeRemaining;
private Button mTestButton;
private static boolean sEnable;

@Override
public void onResume() {
    super.onResume();

    mTestButton.setEnabled(sEnable);
    ....
}

 ...

@Override
public void onRewardedVideoAdLoaded() {
    Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
    sEnable = true;
    mTestButton.setEnabled(sEnable);

}