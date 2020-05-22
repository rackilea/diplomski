import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
Aggregation myDocAggr = newAggregation(
       match(Criteria.where("metaId.ref.uuid").is(someUUID)), 
       group("uuid").max("version").as("version"),
       lookup("simple","execId.ref.uuid","uuid","simple"),
       unwind("simple"),
       new AggregationOperation(){ 
         @Override 
         public Document toDocument(AggregationOperationContext aoc) {
            return new Document("$addFields",new Document("metaId.ref.name","$simple.name"));
         }
      }
)
List<Document> mydocumentList=mongoTemplate.aggregate(myDocAggr,"myDocument",Document.class).getMappedResults();