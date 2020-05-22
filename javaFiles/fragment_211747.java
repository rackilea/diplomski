String str1, str2;

str1 = word.getText().toString();
str2 = answer.getText().toString();

if(!(str1.equals("")) && !(str2.equals("")))
{
  teach.setEnabled(true);
}
else
{
  teach.setEnabled(false);
}