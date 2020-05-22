public static void main(String[] args) throws InterruptedException
    {
        String toBeEscaped = "+-&&||!(){}[]^\"~*?:\\/";
        String input = "(1+1)=2";
        StringBuffer outBuffer = new StringBuffer();
        for (int i = 0; i < input.length(); i++)
        {
            if (toBeEscaped.indexOf((int)input.charAt(i))>-1)
            {
                outBuffer.append("\\");
            }
            outBuffer.append(input.charAt(i));
        }

        System.out.println("Input :"+input);
        System.out.println("Output:"+outBuffer);
    }