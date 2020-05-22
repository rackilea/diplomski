package com.mongodb.sample;

import org.bson.BsonDocument;
import org.bson.Document;

import com.mogodbsample.config.DBconfig;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodbtest.entities.User;

public class Firstmongoaccess {

public static void main(String... args) {
    MongoDatabase dataase = DBconfig.getdatabase();
    MongoCollection<User> collection = dataase.getCollection("users",  User.class);

    User u1 = new User();
    u1.setAddress(new StringBuilder("something street bangalore 356322"));
    u1.setName("xxxxxx");
    u1.setEmail("gh@gmail.com");
    u1.setPhno(3263433);

    collection.insertOne(u1);
    MongoCursor<? extends BsonDocument> cursor = collection.find().iterator();
    try {
        while (cursor.hasNext()) {
            System.out.println(cursor.next().toJson());
        }
    } finally {
        cursor.close();
    }

}
}