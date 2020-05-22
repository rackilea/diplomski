int count = 0;

try
{
    String line = fileReader.readLine();
    while (line != null)
    {
        for(int i = 0; i < line.length(); ++i)
        {
            char ch = line.charAt(i);
            if ((ch == 'a') || (ch == 'A'))
                count++;
        }
        line = fileReader.readLine();
    }
}
catch(Exception e){}