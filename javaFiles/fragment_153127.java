private static final int READ_COUNT = 5; 

public static void main(String[] args) throws IOException
{
    SkipLineBufferedReader li 
        = new SkipLineBufferedReader(new InputStreamReader(System.in));

    int readCharacters = 0;
    int character;

    do
    {
        character = li.read();

        System.out.println("JOB WITH " + character);

        if(++readCharacters >= READ_COUNT)
        {
            li.skipLine();

            break;
        }
    } while(character != '\n');

    System.out.println((char) li.read());
}