DSMBuilder builder = new DSMBuilder(new File("path/to/mapping.yaml")).setType(DSMBuilder.TYPE.XML);

       // register function
        builder.registerFunction("processA",processA);
        builder.registerFunction("processB",processB);
        builder.registerFunction("processC",processC);

        DSM dsm= builder.create();
        Object object =  dsm.toObject(xmlContent);