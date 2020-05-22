public static void main(String[] args) 
    {
        int hcount = 0;
        int tcount = 0;
        Scanner sc = new Scanner(System.in);
        out.println("How many coin flips do you want?");
        int number = sc.nextInt();
        for (int i = 1; i <= number; i++) 
        {
            coin();
            if (getsideup().equals("heads")) 
            {
                hcount++;
            } 
            else 
            {
                tcount++;
            }
        }
        System.out.println("total heads = " + hcount + " total tails = " + tcount);
    }