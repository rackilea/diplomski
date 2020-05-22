OrientGraphFactory ogf = new OrientGraphFactory(
            "plocal:C:/Users/USER/Desktop/orientdb/databases/testJ", "admin", "admin");
    OrientGraph og = ogf.getTx();

    try {
        System.out.println("Features = " + og.getFeatures());
    } finally {
        og.shutdown();
    }