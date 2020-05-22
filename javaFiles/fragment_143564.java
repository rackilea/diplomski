char middle = 'A'; int spaces = input - (int) 'A';
    while( middle <= input) {

        // Print the left side spaces
        for( int i = 0; i < spaces; i++)
            System.out.print(" ");

        // Print the left side of the tree (including the middle)
        for( char y = 'A'; y <= middle; y++)
            System.out.print( y);

        // Print the right side of the tree
        for( char y = Character.toChars( middle - 1)[0]; y >= 'A'; y--)
            System.out.print( y);

        // Print the right side spaces
        for (int i = 0; i < spaces; i++)
            System.out.print(" ");

        // Print a new line
        System.out.println();

        // Subtract 1 from the number of spaces we need
        spaces--; 

        // Increment the middle character
        middle++;
    }