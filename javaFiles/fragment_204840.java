String set[] = new String[3];
    String countSymbols[] = {"*", "+","-","/"}

    /* You can set to however far you want to count here, but in your code, 
      the limit would be (4^3)-1 = 3*(4^2)+3(4^1)+3*(4^0) = 63. We get this
      because there's 4 symbols and 3 digits. */

    for (int i = 0 ; i < 64 ; i++) {
       /* Since you're trying to print them in increasing order, we'll have to set
          the values in reverse order as well. */
       // 4^0 = 1
       set[2] = countSymbols[i%4];

       // 4^1 = 4
       set[1] = countSymbols[(i/4)%4]

       // 4^2 = 16
       set[0] = countSymbols[(i/16)%4]

       printSet(set);
    }