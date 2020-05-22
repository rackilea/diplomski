public void show()
{
    super.show();//Call to super class to let it paint the window
    for(int i =0;i<9;i++)
    {
        for(int j =0;j<9;j++)
        {
            System.out.print(sudoku[i][j]+" ");
        }
        System.out.println("");
    }
}