for (int i=0; i<r50.length; i++)
    {   
        r50[i] = rand.nextInt(1000); //Set it before the j loop
        for (int j = 0; j < i; j++)
        {
            while (r50[i] == r50[j]) //while loop, in case of multiple duplicates
            {
                duplicates = true;  //Still not sure why you want this boolean
                System.out.println("DUPE: " + r50[i]);
                r50[i] = rand.nextInt(1000);
            }
    }
}