@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == 1) {
        if(resultCode == RESULT_OK){
            int score = data.getIntExtra("MY_SCORE", -1);

            if (score > readHighscore()) {
                writeHighscore(resultCode);
            }
        }
    }
}