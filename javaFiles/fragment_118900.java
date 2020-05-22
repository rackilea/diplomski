@Override
public boolean onTouch(View v, MotionEvent event)
{
    //move this whole code to onClick for textviews
    v.setVisibility(View.INVISIBLE);
    if(counter < 10)
    {
        counter++;
        return false;
    }
    if(counter == 10)
    {
        counter = 0;
        populateLayout();
        return false;
    }
    return false;
}