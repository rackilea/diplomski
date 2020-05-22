//from here!

Board[1][1]="S";
boolean isShipFound = false; //Variable to keep track if the ship has been found.
for(int i=0;i<4;i++)
{
    for(int j=0;j<4;j++)
    {
        if(Board[i][j].equalsIgnoreCase("S"))
        {
            isShipFound = true;
            break; //Exits the j loop.
        }
    }
    if (isShipFound)
    {
        break; //Exits the i loop.
    }

}
if(!isFound)
{
    System.out.println("No ship found");
}
else
    System.out.println("Found it");
}