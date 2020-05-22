for(int index = 0; index < data.length; index++)
{
    sum += data[index];

    if (data[index] % 2 == 0)
    {
        // int temp = data[index];
        // data[index] = evenData[index];
        // evenData[index] = temp;

        evenSum += data[index];
    }
    else
    {
        // int temp = data[index];
        // data[index] = oddData[index];
        // oddData[index] = temp;

        oddSum += data[index];  
    } 
}

System.out.println("Even Sum: "  + evenSum);
System.out.println("Odd Sum: "  + oddSum);
System.out.println("Total Sum: "  + sum);