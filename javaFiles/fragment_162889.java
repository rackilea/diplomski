int n = cap - 1;    // will not change anything to the leading bit except
                    // if cap is already a power of 2. In that case,  
                    // we had cap = 001000000000 and now n = 000111111111 and
                    // the other lines won't change anything, we just have to
                    // do +1 in the end and we're done, n = cap;
                    // otherwise, let's assume that not every 'X' is a '0'

n |= n >>> 1;       // n >>> 1 = 0001XXXXXXX
                    // so    n = 0011XXXXXXX

n |= n >>> 2;       // n >>> 2 = 000011XXXXX
                    // so    n = 001111XXXXX

n |= n >>> 4;       //       n = 0011111111X

n |= n >>> 8;       //       n = 00111111111

n |= n >>> 16;      //       n = 00111111111

return n + 1;       //  result = 01000000000