public int stringToNumber(String stn) {
              int number = 0, factor = 1;
              int negative = 0;
              if(stn.charAt(0)=='-') {
                  negative =1;
              }
              for (int n = negative; n < stn.length(); n++) {
                  int digit = stn.charAt(n)-'0';
                  if(digit<0 || digit>9)
                      return 0;
                  if((negative==0) && (Integer.MAX_VALUE-digit)/10 <number) 
                      return 0;
                  else if ((negative==1) && (Integer.MAX_VALUE-digit+1)/10 <number) 
                      return 0;
                  number = number*10+ (stn.charAt(n)-'0');
                 }

              if(negative == 1) {
                  return -1*number;
              }
              return number;
            }