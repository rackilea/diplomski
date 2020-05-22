MongoDatabase mongo = // initialize your connection;
Document matches = new Document("$match",
    new Document("gi", new Document("$ne", null))
    .append("ci", Integer.parseInt(courseid)));

Document firstGroup = new Document("$group",
    new Document("_id",
        new Document("ci", "$ci")
        .append("gi", "$gi")
        .append("gn", "$gn")
        .append("si", "$si"))
    .append("count", new Document("$sum", 1)));

Document secondGroup = new Document("$group",
    new Document("_id",
        new Document("ci", "$_id.ci")
        .append("gi", "$_id.gi")
        .append("gn", "$_id.gn"))
    .append("ns", new Document("$sum", 1))); 

Document sort = new Document("$sort", 
    new Document("_id.gi", 1));             

List<Document> pipeline = Arrays.asList(matches, firstGroup,
    secondGroup, sort);
AggregateIterable<Document> cursor = mongo.getCollection("I1")
    .aggregate(pipeline);

for(Document doc : cursor) { // do stuff with doc }