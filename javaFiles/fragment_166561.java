for(int i = 0; i < 9; ++i) {
        if(i > 0 && i % 3 == 0)
            retVal += '-';

        // bitwise AND with 0xff is to undo sign extension Java
        // does by default
        retVal += (char)('a' + (hash[i] & 0xff) % 26);
    }