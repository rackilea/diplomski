// first, zero out the array using whatever method you want
for(i = 0; i < list20.length; i++)
{
    list20[i] = 0;
}

// then request the values
System.out.println("\nEnter up to 20 non-negative numbers:");
for(i = 0; i < list20.length; i++)
{
    System.out.print("Number "+ (i+1) + ": ");
    input = scan.nextInt();

    if(input>=0)
    { 
        list20[i] = input;
    }
    else
    {
        break;
    }
}

// then total the non-negative values
int total = 0;
if(i >= 20) {
    for(int value : list20)
    {
        if(value > 0) {
            total += value;
        }
    }
}