public void onActivityResult(int reqCode, int respCode, Intent i) {
    if(respCode == 1) {
        switch(reqCode) {
            case ACT_A: resultA = i.getIntExtra("score", resultA);
                        break;
            case ACT_B: resultB = i.getIntExtra("score", resultB);
                        break;
        }
        myTextView.setText("" + (resultA + resultB));
    }
}