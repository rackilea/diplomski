radioGroup = new RadioGroup[4];
    answer = new RadioButton[4];
    int i = 0;
    for (Question qn : questions) {
        radioGroup[i] = new RadioGroup(this);
        radioGroup[i].setOrientation(RadioGroup.VERTICAL);
        int j = 0;
        for (Answer an : answers) {
            if (qn.getID() == an.getQuestion_id_answer()) {
                String answers_log = " " + an.getAnswer();
                answer[j] = new RadioButton(this);
                answer[j].setText(answers_log);
                radioGroup[i].addView(answer[j]);
                j++;
            }
        }
        linearLayout.addView(radioGroup[i]);
        i++;
    }

    finishButton = new Button(this);
    linearLayout.addView(finishButton);

    finishButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (int i = 0; i < radioGroup.length; i++) {
                for (int j = 0; j < radioGroup[i].getChildCount(); j++) {
                    radioGroup[i].getChildAt(j).setBackgroundColor(Color.GREEN);
                }
            }
        }
    });