boolean found = false;
int i;//thanks @DaveNewton !
for (i = 0; i < xArray.length; i++)
{
    if(searchNumber == xArray[i])
    {
        found = true;
        break;
    }
}   

if(found)
    System.out.println("We have found your number " + searchNumber + " at position " + i + " in the array. " );
else
    System.out.println("No match was found.");