Map<String,String> currentInstanceFeatures = currentInstance.getFeatures();
    Instances model = null;
    try {
        if (targetFile.exists()) {
            FileReader in = new FileReader(targetFile);
            try {
                BufferedReader reader = new BufferedReader(in);
                ArffReader arff = new ArffReader(reader);
                model = arff.getData();
            } finally {
                IOUtils.closeQuietly(in);
            }
        } else {
            FastVector schema = new FastVector();
            model = new Instances("model", schema, 1);
        }
        Instance newInstance = new SparseInstance(0);
        newInstance.setDataset(model);

        for(Map.Entry<String,String> feature:currentInstanceFeatures.entrySet()) {
            Attribute attribute = model.attribute(feature.getKey());
                if (attribute == null) {
                    attribute = new Attribute(feature.getKey());
                    model.insertAttributeAt(attribute, model.numAttributes());
                    attribute = model.attribute(feature.getKey());
                }
            newInstance.setValue(attribute, feature.getValue());
        }

        model.add(newInstance);
        model.compactify();
        ArffSaver saver = new ArffSaver();
        saver.setInstances(model);
        saver.setFile(targetFile);
        LOGGER.debug("Saving dataset to: " + targetFile.getAbsoluteFile());
        saver.writeBatch();
    } catch (IOException e) {
        throw new IllegalArgumentException(e);
    }