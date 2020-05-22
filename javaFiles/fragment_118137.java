String[] horizontal = new String[columns-1];
    String[] minusplus = new String[columns];

    int j = 0;

    for(int i = 1; i < columns; ++i)
        {
            minusplus[0] = ("---");
            minusplus[i] = ("+---");
        }

    for(int i = 0; i < horizontal.length; ++i)
        {
            horizontal[i] = ("   |");
        }

    do
    {
        for(int i = 0; i < horizontal.length; ++i)
        {
            System.out.print(horizontal[i]);
        }

        System.out.printf("%n");


        if ( j < lines - 1 ){
        for(int m = 0; m < minusplus.length; ++m)
            System.out.print(minusplus[m]);
        }

        System.out.printf("%n");

        ++j;
    } while ( j < lines);