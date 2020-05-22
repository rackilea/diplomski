charLoop:
    for (i = nextChar; i < nChars; i++) {
        c = cb[i];
        if ((c == '\n') || (c == '\r')) {
            eol = true;
            break charLoop;
        }
    }

    startChar = nextChar;
    nextChar = i;

    if (eol) {
        String str;
        if (s == null) {
            str = new String(cb, startChar, i - startChar);
        } else {
            s.append(cb, startChar, i - startChar);
            str = s.toString();
        }
        nextChar++;
        if (c == '\r') {
            skipLF = true;
        }
        return str;
    }