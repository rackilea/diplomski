Bson filter = new Document("players", Document.parse("{\n" +
            "            $filter: {\n" +
            "               input: \"$players\",\n" +
            "               as: \"player\",\n" +
            "               cond: { $eq: [ \"$$player.nick\", \"player1\" ] }\n" +
            "            }\n" +
            "         }"));
Bson addFields = new Document("$addFields", filter);
col.aggregate(Arrays.asList(addFields));