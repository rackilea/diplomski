builder.setPositiveButton("RED!", new DialogInterface.OnCLickListener() 
{
    public void onClick(DialogInterface dialog, int whichButton) 
    {
        if(t != null)
        {
            t.cancel();
        }
    }
}