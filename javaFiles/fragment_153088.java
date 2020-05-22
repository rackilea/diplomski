Transaction transaction = new DefaultTransaction("create");

    String typeName = newDataStore.getTypeNames()[0];
    SimpleFeatureSource featureSource = newDataStore.getFeatureSource(typeName);

    if (featureSource instanceof SimpleFeatureStore) {
        SimpleFeatureStore featureStore = (SimpleFeatureStore) featureSource;

        featureStore.setTransaction(transaction);
        try {
            featureStore.addFeatures(collection);
            transaction.commit();

        } catch (Exception problem) {
            problem.printStackTrace();
            transaction.rollback();

        } finally {
            transaction.close();
        }
        System.exit(0); // success!
    } else {
        System.out.println(typeName + " does not support read/write access");
        System.exit(1);
    }