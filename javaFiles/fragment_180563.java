int  x= 5;
//      while (x>=0) {
            int y = 3;
//          while (y>0) {
                if (x<2)
                    continue; //<-- COMPILE ERROR: continue cannot be used outside of a loop
                x--; y--;
                System.out.println(x*y + " ");
//          }
//      }