public class Main {

    private BufferedReader userInput;
    private String testString;

    public static void main(final String args[])
    {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));  //get the reader.
        Main test = new Main(userInput); //create an object of a test class that will use this reader
        test.getTestString(); //ask user for the input
        test.removeOsWithRegex();  //first method - regex
        test.removeOsByReplacingWithX(); //second method - in loop change all O's to X's
        test.removeOsByInLoopDeletion(); //third method - delete all O's step by step in a loop.
    }

    public Main(final BufferedReader userInput)
    {
        this.userInput = userInput;  //constructor
    }

    //getting the test string.
    private void getTestString()
    {
        System.out.print("Enter Test String: ");
        try
        {
            testString = userInput.readLine();
            testString = "." + testString + ".";
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Something wrong happened: " + e.getMessage() + ". Shutting down.");
        }
    }

    //removing with regex
    private void removeOsWithRegex()
    {
        System.out.println("Removing 'O' with regexp from: " + testString);

        //change all parts of testString where there are Os followed by X to X.
        //do the same with parts of testString where there is X followed by one or more O.
        String resultString = testString.replaceAll("[O]+X","X").replaceAll("X[O]+", "X");
        //the number of Os is the length of the string minus length of the string without Os.
        int count = resultString.length() - resultString.replace("O", "").length();
        System.out.println("Result string:  " + resultString);
        System.out.println("Total 'O' left:  " + count);
    }

    //2nd method
    public void removeOsByReplacingWithX()
    {
        System.out.println("Removing 'O' by replacing them with X: " + testString);

        byte[] byteArray = testString.getBytes();
        boolean changesMade;
        //create loop
        do
        {
            changesMade = false;
            for (int i = 1; i < byteArray.length - 1; i++)
            {
                //if X was found change adjacent Os to X
                if (byteArray[i] == 'X')
                {
                    if (byteArray[i-1] == 'O')
                    {
                        byteArray[i-1] = 'X';
                        changesMade = true;
                    }
                    if (byteArray[i+1] == 'O')
                    {
                        byteArray[i+1] = 'X';
                        changesMade = true;
                    }
                }
            }
        } while(changesMade);  //do this as long as there is something to change.

        String resultString = new String(byteArray);

        int count = resultString.length() - resultString.replace("O", "").length();
        System.out.println("Result string:  " + resultString);
        System.out.println("Total 'O' left:  " + count);
    }


    //3rd method
    public void removeOsByInLoopDeletion()
    {
        System.out.println("Removing 'O' by deleting them in loop: " + testString);

        byte[] byteArray = testString.getBytes();
        boolean changesMade;
        //create a loop
        do
        {
            changesMade = false;
            for (int i = 1; i < byteArray.length - 1; i++)
            {
                //if there is X
                if (byteArray[i] == 'X')
                {
                    //if next is O then shorten the array by cutting the O
                    if (byteArray[i+1] == 'O')
                    {
                        byteArray = shortenByteArray(byteArray, i+1); //i+1 is the position of O
                        changesMade = true;
                        break;
                    }
                }
                //on the other hand if O was wound
                if (byteArray[i] == 'O')
                {
                    //if X is next, shorten it by cutting O from current position
                    if (byteArray[i+1] == 'X')
                    {
                        byteArray = shortenByteArray(byteArray, i); //i is current position.
                        changesMade = true;
                        break;
                    }
                }
            }
        } while(changesMade);

        String resultString = new String(byteArray);

        int count = resultString.length() - resultString.replace("O", "").length();
        System.out.println("Result string:  " + resultString);
        System.out.println("Total 'O' left:  " + count);
    }

    //cutting one element from byte array
    private byte[] shortenByteArray(final byte[] byteArray, final Integer startIndex)
    {
        byte[] newByteArray = new byte[byteArray.length-1];
        for (int i = 0; i < newByteArray.length; i++)
        {
            //rewrite all before the item to cut
            if (i < startIndex)
            {
                newByteArray[i] = byteArray[i];
            }
            else
            {
                //ommit the element to cut and move all others by 1.
                newByteArray[i] = byteArray[i+1];
            }
        }
        return newByteArray;
    }
}