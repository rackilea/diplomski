int i = 0;
char c;
    do {
        c = (char)i;
        input += c;
        i = in.read();
    } while(i != -1);