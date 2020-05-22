while(! shell.isDisposed())
{
    if(! display.readAndDispatch())
    {
        display.sleep();
    }
}