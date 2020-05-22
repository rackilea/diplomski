double[] arr = new double[10];
    int count=-1;
    for(a=1;a<=10;a++)
    {
        System.out.println("Enter your number");
        b=Double.parseDouble(in.readLine());
        if(b<0)
        {
            arr[++count] = b;
        }
    }
    for(a=1;a<=count;a++) System.out.println(arr[a]);