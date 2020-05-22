@Override
     public void onBackPressed() {
        back.putExtra("ANSWER", answer.getText().toString());
        back.putExtra("QUESTION_ID", questionId);
        setResult(RESULT_OK, back);
        super.onBackPressed();
     }