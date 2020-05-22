private double getScaleFactor()
{
    double hfactor = canvas.getHeight() / cellsHigh;
    double wfactor = canvas.getWidth() / cellsWide;

    return (hfactor < wfactor ? hfactor : wfactor);
}