// Complete the isBalanced function below.
    static String isBalanced(String s) {

        char a[] = new char[1000];
        int top = 0,i=1;
        a[0]=s.charAt(0);
        char retBrack;
        String result;


        while(i<s.length() )
        {
            retBrack=findCorrBracket(s.charAt(top));
            if(s.charAt(i)!=retBrack)
            {
                top++;
                a[top]=s.charAt(i);
            }
            else
            {
                top--;
            }

            i++;
        }


        System.out.println(top);

        if(top==-1)
        {
            result = "YES";
        }
        else
        {
            result = "NO";
        }

        return result;
    }