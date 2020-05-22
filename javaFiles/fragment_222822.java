public static void compare_letters(String name1, String name2) {
    int equal_letters = 0 ;

    for( char c1 : name1.toCharArray() )
        for( char c2 : name2.toCharArray() )
            if( c1 == c2 ) equal_letters++;

    System.out.println("num of equal letters " + equal_letters);
}