for(int i = 0; i < a.length; i++)
{

    for(int j = 0; j < a[i].length; j++)
    {
        if (a[i][j]==1){

            System.out.print("Q");
            if(j < a[i].length - 1) System.out.print(" ");

        } else{
            System.out.print(a[i][j]);
            if(j < a[i].length - 1) System.out.print(" ");
        }
    }
    System.out.println();
}