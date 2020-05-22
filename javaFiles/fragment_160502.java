Scanner ob = new Scanner(System.in);
    int t = ob.nextInt();
    while(t-- > 0)
    {
        int s = ob.nextInt();
        int[] arr = new int[s]; // give the array the correct length
        for(int i = 0; i<s; i++)
        {
            arr[i] = ob.nextInt();
        }
        Arrays.sort(arr); // sort after reading the inputs
        for(int i = 0;i<s;i++)
            System.out.print(arr[i]+" ");
    }