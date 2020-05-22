MyApi api = new MyApi(name->
    new GZIPOutputStream(
        new CipherOutputStream(
            new CheckedOutputStream(
                new FileOutputStream(name),
                new CRC32()), 
            chipper),
       1024, 
       true)
   );