int[] a = new int[someSize];
    int[] b = new int[someSize];
    ....
    // I no longer need 'a'
    a = null;
    // ... but I can still use 'b'