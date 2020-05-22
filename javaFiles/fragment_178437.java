int v = 0b1110_1010_1111_1001_1010_1000_1010_0111;
      short verify = (short) 0b1010_1001_1000_0111;
      // initialize a short value
      short val = 0;

      // increment from 24 to 0 by 8's  the loop will
      // repeat 4 times.
      for (int i = 24; i >= 0; i -= 8) {
         // start by shifting the result left 4 bits
         // first time thru this does nothing.
         val <<= 4;

         // Shift the integer right by i bits (first time is
         // 24, next time is 16, etc
         // then mask off the lower order 4 bits of the right
         // most byte and OR it to the result(val).
         // then when the loop continues, val will be
         // shifted left 4 bits to allow for the next "nibble"

         val |= ((v >> i) & 0xf);
      }
      System.out.println(val);
      System.out.println(verify);