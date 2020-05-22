int i = 0;
    for (Iterator<String> it = words.iterator(); it.hasNext(); )
    {
        it.next(); // Add this line in your code
        if (i % 2 != 0)
        {
            it.remove();
        }
        i++;
    }