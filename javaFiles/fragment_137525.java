int count = 0;

try
{
    Reader fileReader = new FileReader("letters01.dat");
    /* or:
    Reader fileReader = new InputStreamReader(
        new FileInputStream("letters01.dat"),
        "the file's charset here"
    ); 
    */

    int value = fileReader.read();
    while (value != -1)
    {
        char ch = (char) value;
        if ((ch == 'a') || (ch == 'A'))
            count++;
        value = fileReader.read();
    }
}
catch(Exception e){}