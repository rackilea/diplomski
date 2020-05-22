public String encryptInput(String inputString)
{
    /* Array to calculate the new values (a-z)*/
    char[] caesArray = {'a', 'b', 'c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p','q','r','s','t',
            'u','v','w','x','y','z', ' ', '.'};

    /* Array for users input */
    char[] inputArray = new char[inputString.length()];
    char resultChar= ' ';
    char[] resultArray = new char[inputString.length()];

    /* saves the String characters into the inputArray */
    for(int i = 0 ; i < inputArray.length; i++)
    {
        inputArray[i] = inputString.charAt(i);
    }

    for(int i = 0 ; i < inputArray.length ; i++)
        for(int j = 0 ; j < caesArray.length ; j++)
        {

             if (caesArray[j] == inputArray[i])
             {
                 /* My special characters */
                 switch(inputArray[i])
                {
                case ' ': resultChar = ' ';
                break;
                case '.': resultChar = '.';
                break;
                }

                if(inputArray[i] == caesArray[caesArray.length - 1])
                {
                    inputArray[i] = caesArray[1];
                }
                else if(inputArray[i] == caesArray[caesArray.length - 2])
                {
                    inputArray[i] = caesArray[0];                       
                }
                else
                {
                    resultChar = caesArray[j+2];
                }
                 System.out.print(resultChar);
                 resultArray[i] = resultChar;
             } 
        }
    return new String(resultArray);
}