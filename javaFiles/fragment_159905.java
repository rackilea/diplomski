for (int i = 0; i < facesArray.length; i++)
{
    ...
    for (int j = 0; j < eyesArray.length; j++)
    {
        ...
        Point center1 = new Point(
            facesArray[i].x + eyesArray[i].x + eyesArray[i].width * 0.5, 
            facesArray[i].y + eyesArray[i].y + eyesArray[i].height * 0.5);
    ...