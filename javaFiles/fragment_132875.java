public YourClass {

  private CountDownTimer cdt;

  .... (do whatever)....

  public void startService(android.view.View view) {
final SharedPreferences sP = getSharedPreferences("com.example.safetyNet", MODE_PRIVATE);
final Button button = findViewById(R.id.button3);
final Intent transIntent = new Intent(this, CheckPinActivity.class);

if (cdt == null) {
 cdt = new CountDownTimer(sP.getInt("TiT", 10) * 1000, 1000) {
    @Override
    public void onTick(long millisUntilFinished) {
        button.setText(String.valueOf(millisUntilFinished).substring(0,2));
    }

    @Override
    public void onFinish() {
        if(sP.getBoolean("lockedDown", false) == true){
            startActivity(transIntent);
        }
    }
};
} else {
  cdt.cancel();
  }
   cdt.start();
}