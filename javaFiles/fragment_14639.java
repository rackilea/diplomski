import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Update;

...

WriteResult wr = mongoTemplate.updateMulti(
    new Query(where("commentsList.id").is("123")),
    new Update().inc("commentsList.$.numberOfLikes", 1),
    MongoPost.class
);