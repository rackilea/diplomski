Button mover[][] = new Button[7][7];
int i = 0;
int j = 0;
for(i=0;i<7;i++)
{
    for(j=0;j<7;j++)
    {
        if(i<=1 && j<=1 || i>=6 && j<=1 || i<=1 && j>=6 || i>=6 && j>=6)
        {
            continue;
        }

        System.out.println("Setting mover["+i+"]["+j+"]");      
    }
}