boolean mouseDragged = false;

void draw()
{
    if (mousePressed == false)
    {
        mouseDragged = false;
    }

    println(mouseDragged);
}

void mouseDragged()
{
    mouseDragged = true;
}