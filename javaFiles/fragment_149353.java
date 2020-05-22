private int importUnsorted(String jsonFile, ColumnFamily columnFamily, String ssTablePath, IPartitioner<?> partitioner) throws IOException
        {
            int importedKeys = 0;
            long start = System.currentTimeMillis();

            JsonParser parser = getParser(jsonFile);

            Object[] data = parser.readValueAs(new TypeReference<Object[]>(){});

            keyCountToImport = (keyCountToImport == null) ? data.length : keyCountToImport;
            SSTableWriter writer = new SSTableWriter(ssTablePath, keyCountToImport);

            System.out.printf("Importing %s keys...%n", keyCountToImport);

            // sort by dk representation, but hold onto the hex version
            SortedMap<DecoratedKey,Map<?, ?>> decoratedKeys = new TreeMap<DecoratedKey,Map<?, ?>>();

            for (Object row : data)
            {
                Map<?,?> rowAsMap = (Map<?, ?>)row;
                decoratedKeys.put(partitioner.decorateKey( hexToBytes((String)rowAsMap.get("key"))), rowAsMap);
....