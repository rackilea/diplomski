private static void updateValue(final String name, final Object defaultValue, final UUID key) {
        if (!exists(name, key)) {
            FindIterable iterable = players.find(new Document("_id", key));

            iterable.forEach(new Block<Document>() {

                @Override
                public void apply(Document document) {
                    players.updateOne(new Document("_id", key), new Document("$set", new Document(name, defaultValue)));
                }
            });
        }
    }

    private static boolean exists(String name, UUID key) {
        Document query = new Document(name, new Document("$exists", true)).append("_id", key);

        return players.count(query) == 1;
    }