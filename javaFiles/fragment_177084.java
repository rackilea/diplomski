static char findCorrBracket(char b)
    {
        if(b == '{')
        {
            return '}';
        }
        else if(b == '[')
        {
            return ']';
        } 
        else if(b == '(')
        {
            //Use else if here instead of else, since otherwise '}',']','(' & ')' will all get the returned character value ')'
            return ')';
        } else {
            return '_';
        }
    }

    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        char a[] = new char[1000];
        int top = 0,i=1;
        a[0]=s.charAt(0);
        char retBrack;
        String result;

        while(i<s.length())
        {
            if(top == -1) {
                //If the stack is empty, then we don't need to get the 'correct bracket' and check
                //We can directly insert the character into the stack
                top++;
                a[top] = s.charAt(i);
            } else {
                //findCorrBracket from `a[top]`, not from `s.charAt(top)`
                retBrack = findCorrBracket(a[top]);
                if (s.charAt(i) != retBrack) {
                    top++;
                    a[top] = s.charAt(i);
                } else {
                    top--;
                }
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