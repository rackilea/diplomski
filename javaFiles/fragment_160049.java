if (mButtonBClicked)
{
    // button B is clicked again, stop application
}
else
{
    mButtonBClicked = true;
    mButtonAClicked = false;
    if (mStartTime != 0) // Button A was clicked
    {
         Long endtime = System.currentTimeMillis();
         Long differenz = ((endtime-starttime) / 1000);
         mStartTime = System.currentTimeMillis();
    }
}