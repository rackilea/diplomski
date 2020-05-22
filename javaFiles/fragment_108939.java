btn_doneAnswer = (Button) findViewById(R.id.btn_doneAnswer);
    btn_doneAnswer.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
                String text;
               for (int a = 0; a < Arr.length; a++) {
                    text += Et[a].getText().toString();
                }
                Bundle bundle = new Bundle();
                Intent i_backToAddItem = new Intent(
                        AnswerActivityMultiText.this,
                        QuestionActivityDynamic.class);
                bundle.putString("text", text);
                bundle.putString("MultiQues", MultiQues);
                i_backToAddItem.putExtras(bundle);
                startActivity(i_backToAddItem);

        }
    });