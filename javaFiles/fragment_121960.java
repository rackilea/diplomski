int[] input;
        //input - array of integers (one integer for 32 coins)
        if(N%32>0)
            input = new int[N/32 + 1];
        else
            input = new int[N/32];