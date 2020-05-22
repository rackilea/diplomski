for (int i=0;i<4;i++)
{
    if(!text.hasNextInt()) break;
    for (int j=0;j<4;j++)
    {
        if(!text.hasNextInt()) break;
        matrix1[i][j]= text.nextInt();
    }
}