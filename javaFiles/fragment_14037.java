//checks the variable, and calls according showdialog.
    if(is24HoursSet)
    {
        showDialog(START_TIME_24);
    }
    else 
    {
        showDialog(START_TIME_12);
    }