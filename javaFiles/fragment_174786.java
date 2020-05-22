int[] freq = new int[128]; // enough for ASCII characters
freq['A'] = 10;            // okay: ASCII character
freq['Ä'] = 10;            // not okay, will throw an ArrayIndexOutOfBoundsException
                           // as Ä is not an ASCII character

int[] freq = new int[256]; // enough for ASCII characters plus all
                           // 8-bit wide characters
freq['A'] = 10;            // okay: ASCII character
freq['Ä'] = 10;            // okay: Ä has the code 196 in UTF-8 which is not ASCII
                           // but our array is large enough to hold it