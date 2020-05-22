profession_text.setTextColor(Color.BLACK);
profession_text.setText("");
if (getProfessionName != null) {
    for (int i = 0; i < getProfessionName.size(); i++) {
        String txt = profession_text.getText().toString() + getProfessionName.get(i) + ", ";
        profession_text.setText(txt);
    }
}