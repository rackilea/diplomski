for (int k = 0; k < choiceElementList.size(); k++) {

    if (choiceElementList.get(k).dataFormatId == 1) {
        RadioButton radioButton = new RadioButton(getContext());

        // Set ID to Radio Button
        radioButton.setId(k);

        radioButton.setText(choiceElementList.get(k).getDataFormatValue());
        radioButton.setLayoutParams(params1);
        radioButton.setPadding(0, 5, 0, 5);
        Log.e("setid", String.valueOf(choiceElementList.get(k).getId())) ;
        radioGroup.addView(radioButton);
    } 
}