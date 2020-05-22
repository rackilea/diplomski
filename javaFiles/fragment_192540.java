private static Rect rotateRect(Rect rect, int heightPercentage, int widthPercetange)
{
    int rwidth  = rect.width;
    int rheight = rect.height;

    rect.width = Math.round((rect.width * widthPercetange) / 100.0f);
    rect.height = Math.round((rect.height * heightPercentage) / 100.0f);        
    rect.x += (rwidth - rect.width) / 2;
    rect.y += (rheight - rect.height) / 2;

    return rect;
}