int x_lim = 2;
int y_lim = 3;

int count=1;
for(int x=1;x<3+1;x++)
{
    for(int y=1;y<3+1;y++)
    {
        if(x_lim==x && y_lim==y)  //skip case (blank tile)
        {
            System.out.println("x"+" ");
        }
        else  //other numbers
        {
            System.out.println(count+" ");
            count++;            
        }

    }
}