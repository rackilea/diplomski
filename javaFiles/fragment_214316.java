public static void main(String args[])
    {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a number: ");
    String input = in.nextLine();
    System.out.println(isFriendly(input));
    }
    public static String isFriendly(String input)
    {
        int n = input.length();
        String output = "";
        StringBuilder sb = new StringBuilder("");
        int myIntOutput=0;
        for (int i = 0; i<n; ++i)
        {
            sb.append(input.charAt(i));

            if (Integer.parseInt(sb.toString())%(i+1)==0)
            {
               myIntOutput++;

            }


        }
        if(myIntOutput==n)
        {
            output="Friendly";
            return output;
        }
        else
        {
            output="Not Friendly";
            return output;
        }
    }