public void processLightClick(int row, int col) {
{
    if(row == 0) // it is the first row, change the one below only
        changeLight(row+1,col);
    else if(row == n-1)
        changeLight(row-1,col); //change the one above only
    else
    {    //change both
        changeLight(row+1,col);
        changeLight(row-1,col);
    }

    if(col == 0) 
        changeLight(row,col+1);
    else if(col == n-1) 
        changeLight(row,col-1);
    else
    {
        changeLight(row,col+1);
        changeLight(row,col-1);
    }

    changeLight(row,col); // the clicked cell  
}