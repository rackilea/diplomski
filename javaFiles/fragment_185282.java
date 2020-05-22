...
if (c != null && !cursor.isAfterLast())
{
    nameTxt.setText(c.getString(1));
    phoneTxt.setText(c.getString(2));
    emailTxt.setText(c.getString(3));
}