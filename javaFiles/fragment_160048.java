if (mButtonAClicked)
{
    // button A is clicked again, stop application
}
else
{
    mButtonAClicked = true;
    mButtonBClicked = false;
    if (mStartTime != 0) // Button B was clicked
    {
         Long endtime = System.currentTimeMillis();
         Long differenz = ((endtime-starttime) / 1000);
         mStartTime = System.currentTimeMillis();
    }
}