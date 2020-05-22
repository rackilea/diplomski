public static void shiftRight( char [] letters )
    {

        char last = letters[letters.length-1];          // save off first element

        // shift right
        for( int index =letters.length-2; index >= 0 ; index-- )
            letters[index+1] = letters [index];

        // wrap last element into first slot
        letters[0] = last;
        System.out.print("\nshifted Array: " + Arrays.toString(letters) );

    }