for (int i=8; i>0; i--) {
    // print 8-i spaces, i.e. the complement number of spaces
    for (int j=0; j<8-i; j++)
        System.out.print(' ');
    for (int j=0; j<i; j++)
        System.out.print('#');
    System.out.println("");
}