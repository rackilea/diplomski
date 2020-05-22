int[] input = {2,1,3}; 
    for (int line = 0; line < 3; line++)
    {          
        for (int inputI=0; inputI < input.length; inputI++)
        {
            int value = input[inputI];
            System.out.print(num[value][line]);
            System.out.print("  ");
        }          
        System.out.println();
    }