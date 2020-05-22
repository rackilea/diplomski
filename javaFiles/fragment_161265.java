/* Init socket here... */
    Socket sock = new Socket(...);

    /* Set time out to next to nothing. */
    sock.setSoTimeout(1);

    /* Setup Streams */
    InputStream is = sock.getInputStream();     

    /*  Pick a buffer size, any reasonable size will do: 1k,2k,4k... */
    byte[] buf = new byte[1024 * 2];
    int lastRead = 0;

    do {
        try {
            lastRead = 0;
            lastRead = is.read(buf);
        } catch (SocketTimeoutException ste) {
          /* Do something, or not.  Your call! */
        }

        /*do something with 'buf' here */

    } while (lastRead > 0);