Bson addFiledsStage = addFields(new Field<Document>("arrSize", new Document("$size", "$arr")));
Bson sortStage = sort(descending("arrSize"));
List<Bson> pipeline = Arrays.asList(addFiledsStage, sortStage);
List<Document> results = new ArrayList<>();
collection.aggregate(pipeline).into(results);   
results.forEach(System.out::println);