public class MyTextWatcher implements TextWatcher
{
private transient EditText editText = null;
public MyTextWatcher(EditText editText)
{
super();
this.editText = editText;
}
    @Override
public void afterTextChanged(Editable arg0)
{
    // TODO Auto-generated method stub

}

@Override
public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3)
{
    // TODO Auto-generated method stub

}

@Override
public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3)
{
    // TODO Auto-generated method stub
}
}