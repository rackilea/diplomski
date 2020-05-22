long[] arr = new long[20];

    for(int i = 1 ; i < arr.length ; i ++){

        if ( i % 2 == 0)
        {
            arr[i] = i * arr[i - 1];
        }
        else
        {
            arr[i] = i + arr[i - 1];
        }
    }