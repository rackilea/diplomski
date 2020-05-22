//Try this 
                 while (true) {
                    int ch = incoming.read();
                    if (ch == 1 || ch == '\r'||ch == -1)
                        break;
                        System.out.print((char)ch);
                      }