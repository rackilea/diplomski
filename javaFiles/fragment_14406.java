String result = ""
for (int c=0; c<array.size(); c++)
{
    String curString = array.get(c);
    result.concat(curString);
}
textview.setText(result);