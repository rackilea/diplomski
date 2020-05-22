myEditText.setOnKeyListener(new View.OnKeyListener()
{
    public boolean onKey(View v, int keyCode, KeyEvent event)
    {
        EditText edittxt = (EditText)v;

        todoItems.add(0, edittxt.getText().toString());

        return false;
    }
});