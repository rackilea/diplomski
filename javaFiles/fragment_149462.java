for (int i = 0; i < outerLayout.getChildCount(); ++i)
{
    try
    {
        LinearLayout innerLayout = (LinearLayout)outerLayout.getChildAt(i);

        if (innerLayout != null)
        {
            for (int j = 0; j < innerLayout.getChildCount(); ++j)
            {
                Button btn = (Button)innerLayout.getChildAt(j);

                //Do something with btn
            }
        }
    }
    catch (ClassCastException cEx)
    {
        Log.w("WARN", "Unexpected child type in outerLayout. " + cEx.getMessage());
    }
}