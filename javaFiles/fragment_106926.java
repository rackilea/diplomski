private OnClickListener tablerowOnClickListener = new OnClickListener()
{
    public void onClick(View v)
    {
        //Highlight selected row
        for (int i = 0; i < table_layout.getChildCount(); i++)
        {
            View row = table_layout.getChildAt(i);
            if (row == v)
            {
                row.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            }
            else
            {
                //Change this to your normal background color.
                row.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            }
        }
        //...
    }
};