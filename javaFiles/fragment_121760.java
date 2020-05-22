//Printing j *'s at the end of each row 
int mid = (row+1) / 2;
    for (int j = row; j > 0; j--) 
    {
        if(i==0 && j==mid) System.out.print("o ");
            else System.out.print("* ");
    }