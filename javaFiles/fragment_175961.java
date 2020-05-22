boolean collectionExists = mongoClient.getDatabase("db_feed").listCollectionNames()
                .into(new ArrayList<>()).contains("capped_collection");

        if(!collectionExists) {
            database.createCollection("capped_collection",
                    new CreateCollectionOptions().capped(true).sizeInBytes(327).maxDocuments(1).autoIndex(true));
        }