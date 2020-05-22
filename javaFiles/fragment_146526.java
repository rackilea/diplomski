char[] buf = new char[len];
        int read = 0;
        int readTo = 0;
        while (read > -1)
        {
            read = r.read(buf, readTo, 1000);
            readTo += read;
        }