public void onDraw(Canvas canvas) 
{
    canvas.drawRect(0, 0, width, height, background);
    int drawSizeX = 5;
    int drawSizeY = 5;
    for(int i = 0; i < drawSizeX - 1; i++) 
    {
        for(int j = 0; j < drawSizeY - 1; j++){
            float x = j * totalCellWidth;
            float y = i * totalCellHeight;
            if(vLines[i + maze.scrollX][j + maze.scrollY]) {
                //we'll draw a vertical line
                canvas.drawLine(x + cellWidth,   //start X
                                y,               //start Y
                                x + cellWidth,   //stop X
                                y + cellHeight,  //stop Y
                                line);
            }
            if(hLines[i + maze.scrollX][j + maze.scrollY]) {
            //we'll draw a horizontal line
                canvas.drawLine(x,               //startX 
                                y + cellHeight,  //startY 
                                x + cellWidth,   //stopX 
                                y + cellHeight,  //stopY 
                                line);
            }
        }
    }
}