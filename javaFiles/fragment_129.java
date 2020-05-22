private static final String DIGITS = "0123456789";

public static String convertPostfixtoInfix(String toPostfix)
{
    LinkedStack<String> s = new LinkedStack<>();
    StringBuilder digitBuffer = new StringBuilder();  

    /* I've changed the 'for' to 'while' loop, 
       because we have to increment i variable inside the loop, 
       which is considered as a bad practice if done inside 'for' loop
    */
    int i = 0;
    while(i < toPostfix.length()) 
    {
        if(DIGITS.indexOf(toPostfix.charAt(i)) != -1)
        {
            //when a digit is encountered, just loop through toPostfix while the first non-digit char is encountered ...
            while (DIGITS.indexOf(toPostfix.charAt(i)) != -1) {
                digitBuffer.append(toPostfix.charAt(i++)); //... and add it to the digitBuffer
            }
            s.push(digitBuffer.toString());
            digitBuffer.setLength(0); //erase the buffer
        }
        //this if-else can also be replace with only one "if (toPostfix.charAt(i) != ' ')"
        else if(toPostfix.charAt(i) == ' ');{}//do nothing for blank.
        else
        {
            String temp = "";
            temp += toPostfix.charAt(i);

            String num1 = s.top();
            s.pop();
            String num2 = s.top();
            s.pop();
            s.push("(" + num2 + temp + num1 + ")");
        }
        i++;
    }

    return s.top();//top() is same as peek() method.
}