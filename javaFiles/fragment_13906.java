DataInputStream dis = new DataInputStream(...);
    byte[] buf = new byte[1024];
    int lastRead = 0;

    do {
        lastRead = dis.read(buf);
        //do something with 'buf' here

    } while (lastRead > 0);