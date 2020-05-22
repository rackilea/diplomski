boolean[] noDuplicate1 = new boolean[numNouns];
        boolean[] noDuplicate2 = new boolean[numAdjectives];

        int numTabsToPrint = 0;                             // Tracks number of tabs to print on each line.

        for(int i = 0; i < 1000; i++)
        {               
            int num1 = (int) (Math.random() * numNouns); 
            int num2 = (int) (Math.random() * numAdjectives);

            if (noDuplicate1[num1] == false && noDuplicate2[num2] == false)
            {
                for (int j = 0; j < numTabsToPrint; j++)    // change 'i' to 'numTabsToPrint' in your original code.
                {
                    System.out.print("\t");
                }
                System.out.println(adjectives[num2] + nouns[num1]);
                noDuplicate1[num1] = true;
                noDuplicate2[num2] = true;
                numTabsToPrint++;                           // increment after printing current line.
            }
        }