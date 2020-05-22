public void onClick(View v) {

String clickedText;

switch(v.getId())
{
   case R.id.your_1st_button_id:
   clickedText=your_textView.getText().toString();
   break;
   case R.id.your_2nd_button_id:
   clickedText=your_1st_textView.getText().toString();
   break;
   case R.id.your_3rd_button_id:
   clickedText=your_3rd_textView.getText().toString();
   break;

 }

  list.add(clickedText);

}