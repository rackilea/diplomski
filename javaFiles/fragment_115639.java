//2nd Pattern         
    System.out.println("\nPattern B:");
    int patternBMax = max;
    for (int i = -5; i <= patternBMax; i++, patternBMax--)
    {
        for (int j = 1; j <= patternBMax; j++)
        {
            System.out.print(j + " ");
        }

        System.out.println();
    }

    // 3rd pattern and WHERE PROBLEM STARTS!!
    System.out.println("\nPattern C:");
    int patternCMax = max;
    for (int i = 1; i <= patternCMax; i++)
    {
        // Pad the output with the necessary whitespace
        for (int j = 0; j < patternCMax - i; j++)
        {
            System.out.print("  ");
        }

        for (int k = i; k > 0; k--)
        {
            System.out.print(k + " ");
        }

        System.out.println();
    }