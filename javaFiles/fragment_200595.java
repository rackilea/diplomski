// you need the ID of the layout - in this example the ID is myLayout
// or you get the layout object instance otherwise
LinearLayout layoutMyLayout = (LinearLayout) findViewById(R.id.myLayout);
if (layoutMyLayout != null)
{
  for (int i = 0; i < layoutMyLayout.getChildCount(); x++)
  {
    View viewChild = layoutMyLayout.getChildAt(i);
    if (viewChild instanceof EditText)
    {
        // get text from edit text
        String text = ((EditText)viewChild).getText().toString();
        //TODO: add rest of the logic
    } else if(viewChild instanceof TextView) {
        // get text from text view
        String text = ((TextView)viewChild).getText().toString();
        //TODO: add rest of the logic
  }
}