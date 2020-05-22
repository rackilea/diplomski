public void display() 
{
    for(int i = 0; i < 3; i++)
    {
        for(int j = 0; j < 3; j++)
        {
            String tile = board[i][j];

            if (tile == null)
                System.out.print("- ");
            else
                System.out.print(tile + " ");
        }

        System.out.println();
    }
}