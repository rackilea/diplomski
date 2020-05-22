public static boolean checkL2(File file) throws IOException
    {
        Stack l2Stack = new Stack();
        boolean bStart = false;
        char w;

        Scanner sc = new Scanner(file).useDelimiter("\\s*");

        while(sc.hasNext()) //Load input from file onto stack
        {
            w = sc.next().charAt(0);

            if (w == 'A')
            {
                if (bStart == true)
                {
                    return false;
                }
                else
                {
                    l2Stack.push('A');
                }
            }
            if (w == 'B')
            {
                bStart = true;
                if (l2Stack.isEmpty() == true)
                {
                    return false;
                }
                else
                {
                    l2Stack.pop();
                }
            }
        }
        sc.close();
        if (l2Stack.isEmpty() == true)
        {
            return true;
        }
//Added return 
    return false;
    }