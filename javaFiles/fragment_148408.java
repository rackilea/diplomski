int ar[] = { 7, 5, 2, 8, 4, 9, 6 };
    int sorted[] = new int[6];

    int smallestFound=-1;
    for (int i=0; i<ar.length-1; i++)
    {
        int smallest = 1000000;
        for (int j=0; j<sorted.length; j++)
        {
            if (ar[j] < smallest && ar[j]>smallestFound) {
                smallest = ar[j];
            }
        }
        smallestFound=smallest;
        sorted[i] = smallest;
    }

    for(int i=0; i<sorted.length; i++)
    {
        System.out.println("sorted[" + i + "] = " + sorted[i]);
    }