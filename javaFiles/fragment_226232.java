@Override
public void onClick(View v) {
  String final_text ="";
  for (String abc: list){
   final_text = final_text +"\n" + abc;
  }
  editText.setText(final_text);
}