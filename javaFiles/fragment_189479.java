// More code

PrintStream output = new PrintStream(new File("display.txt"));
while (inputfile.hasNext())
{
    if (inputfile.hasNextInt())
    {
        int next = inputfile.nextInt();
        int even = (next % 2);
        if (even == 0)
        {
            output.println(next);
            System.out.println(next);
            count++;
        }
    }
    else
    {
        inputfile.next();
        continue;
    }
}

// More code