@Override
public void onFinish() {
    Intent intent = new Intent();
    intent.putExtra("MY_SCORE", score);
    setResult(RESULT_OK, intent);
    finish();
}