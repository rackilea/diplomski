static void getChars(int i, int index, char[] buf) {
       int q, r;
       int charPos = index;
       char sign = 0;

       if (i < 0) {
           sign = '-';
           i = -i;
       }

       // Generate two digits per iteration
       while (i >= 65536) {
           q = i / 100;
       // really: r = i - (q * 100);
           r = i - ((q << 6) + (q << 5) + (q << 2));
           i = q;
           buf [--charPos] = DigitOnes[r];
           buf [--charPos] = DigitTens[r];
       }

       // Fall thru to fast mode for smaller numbers
       // assert(i <= 65536, i);
       for (;;) {
           q = (i * 52429) >>> (16+3);
           r = i - ((q << 3) + (q << 1));  // r = i-(q*10) ...
           buf [--charPos] = digits [r];
           i = q;
           if (i == 0) break;
       }
       if (sign != 0) {
           buf [--charPos] = sign;
       }
   }