MongoClient client = new MongoClient("localhost", 27017);
 MongoDatabase database = client.getDatabase("db");
 MongoCollection<Document> collection = database
                .getCollection("collection");

 Bson filter = Filters.eq("_id", new ObjectId("58f9f7a91fb2bf7c46abe5d6"));

 List<VideoResult> results = collection.aggregate(Arrays.asList(Aggregates.match(filter), Aggregates.unwind("$playlists"), Aggregates.project(Projections.fields(Arrays.asList(Projections.computed("videos", new Document("$size","$playlists.videos")),
                Projections.computed("video_ids", "$playlists.videos.video_id")))))).map(VideoResult::new).into(new ArrayList<>());