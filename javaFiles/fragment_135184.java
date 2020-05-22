MultipartEntityBuilder.create()
    .addBinaryBody("bin"                 // Important! Defined by the server 
        , new File("testScanFile.txt")   // Not important, user defined
        , ContentType.APPLICATION_JSON   // Maybe ignored. Depends
        , "testScanFile.txt"             // User defined
).build();