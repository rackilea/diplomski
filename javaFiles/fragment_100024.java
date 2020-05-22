import static com.mongodb.client.model.Filters.*;

// ...

collection.find(eq("functionalityName", "specificValue"))
      .sort(new Document("date",-1))
      .first()
      .getDate()