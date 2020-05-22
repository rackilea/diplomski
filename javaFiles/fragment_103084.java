public static void encrypt (String a)throws IOException 
{

    //Array of the length of the Plain Text is created
    char pt[] = new char[count];

    //File is opened again and this time passed into the plain text array 
    FileInputStream f = new FileInputStream("/Users/avtrulzz/Documents/file1.txt") ;

    int s ;

    int i = 0 ;

    while((s = f.read()) != -1)

    {
    //Every character read is simultaneously fed into the array
        pt[i] = (char) s ;
            i ++ ;
    }

    //Find the length of the key
    int kl = a.length() ;
    //Find how many times the key has to be repeated
    int keyrep = count / kl ;

    //Where keyrep is the number of times you want to repeat the string and a is the string  to repeat.
    String repeated = new String(new char[keyrep]).replace("\0", a);

    System.out.println("The key repeated till the length of the plain text");
    System.out.println();
    System.out.println(repeated);

    //The string "repeated" is made into an array "keyforpt"
    char keyforpt[] = repeated.toCharArray() ;


    char ct[] = new char[count] ;

    for(int ind = 0; ind < pt.length ; ind++)

    {
        ct[ind] = toChar((toInt(pt[ind]) + toInt(keyforpt[ind]) + 1) % 26);
    }

    System.out.println() ;
    for(int temp = 0;temp < ct.length;temp++)
        {

            System.out.print(ct[temp]) ;
        }
    System.out.println() ;
}


private static int toInt(char chr)
{
    return chr - 'a';
}

private static char toChar(int value) 
{
    return (char)(value + 'a');
}