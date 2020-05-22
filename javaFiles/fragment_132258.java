MongoCredential credential = MongoCredential.createMongoX509Credential(
            "CN=client,OU=kerneluser,O=10Gen,L=New York City,ST=New York,C=US"
    );

    MongoClient client = new MongoClient(
        new ServerAddress("192.168.1.1"),
        Arrays.asList(credential),
        new MongoClientOptions.Builder().socketFactory(
            SSLSocketFactory.getDefault()).build()
    );