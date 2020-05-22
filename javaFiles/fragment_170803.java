private static void triangle(int height) {
        int valueToPrintNext = 0;

        for(int i = 0; i < height; i++)
        {
            for(int j = -1; j < i; j++)
            {
                System.out.print(valueToPrintNext + " ");
                valueToPrintNext = valueToPrintNext==0 ? 1 : 0;
            }

            System.out.println();
        }
    }