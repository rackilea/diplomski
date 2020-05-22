JSONArray jsonQuestion = new JSONArray(obj.get("question").toString());

for (int iii = 0; iii < jsonQuestion.length(); iii++) {
    LinearLayout lll = new LinearLayout(Questionnaire.this);
    lll.setOrientation(LinearLayout.VERTICAL);

    JSONObject obj2 = (JSONObject) jsonQuestion.get(iii);
    System.out.println(obj2.get("question"));

    TextView tv = new TextView(Questionnaire.this);
    tv.setText(obj2.get("question").toString());
    lll.addView(tv);

    JSONArray jsonAnswer = new JSONArray(obj.get("answer").toString());
    Log.d("Reading Answer: ", jsonAnswer + "");

    RadioGroup group = new RadioGroup(Questionnaire.this);
    group.setOrientation(RadioGroup.HORIZONTAL); // RadioGroup.HORIZONTAL or RadioGroup.VERTICAL

   for (int iiii = 0; iiii < jsonAnswer.length(); iiii++) {
        JSONObject obj3 = (JSONObject) jsonAnswer.get(iiii);
        System.out.println(obj2.get("questiosysid").toString().matches(obj3.get("questionid").toString()));
        if (obj2.get("questiosysid").toString().matches(obj3.get("questionid").toString())) {
            TextView tv1 = new TextView(Questionnaire.this);
            tv1.setText(obj3.get("inputname").toString());

            if (obj3.get("inputtype").toString().matches("radio")) {
                RadioButton newRadioButton = new RadioButton(Questionnaire.this);
                newRadioButton.setId(Integer.parseInt(obj3.get("answerid").toString()));
                newRadioButton.setText(obj3.get("inputname").toString());
                group.addView(newRadioButton);
            }
        }
    }
    lll.addView(group);
    ll.addView(lll);
}