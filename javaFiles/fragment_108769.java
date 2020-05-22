private void pageMove (int step)
{
    moveCounter = moveCounter + step;
    if (moveCounter < 0) moveCounter = 0;
    if (moveCounter > values.size ()) moveCounter = values.size ();
    renderValues (currentIndex, false);
}

private void pageNext ()
{
    pageMove (defaultStep);
}

private void pagePrevious ()
{
    pageMove (-defaultStep);
}