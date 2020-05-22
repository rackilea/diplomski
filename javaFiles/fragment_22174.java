@Override
public void onBackPressed() {
    // super.onBackPressed();
    Intent intent = new Intent();
    intent.putExtra("EXIT", true);
    setResult(RESULT_OK, intent);
    finish();
}