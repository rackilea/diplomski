for (each row)
{
    int zeroes = 0;

    for (each column)
    {
        if (arrayValue == 0) zeroes++
    }

    if (zeroes == 0) System.out.println("All ones, row: " + row);

    if (zeroes == columnCount) System.out.println("All zeroes, row: " + row);

}