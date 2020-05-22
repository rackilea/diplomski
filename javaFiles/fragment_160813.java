long num = (bytesArray[7] << 56 |
                  (bytesArray[6] & 0xFF) << 48 |
                  (bytesArray[5] & 0xFF) << 40 |
                  (bytesArray[4] & 0xFF) << 32 |
                  (bytesArray[3] & 0xFF) << 24 |
                  (bytesArray[2] & 0xFF) << 16 |
                  (bytesArray[1] & 0xFF) << 8 |
                  (bytesArray[0] & 0xFF) << 0 );