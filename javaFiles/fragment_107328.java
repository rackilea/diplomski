package com.fabrikam.functions;

import com.microsoft.azure.serverless.functions.annotation.*;
import com.microsoft.azure.serverless.functions.ExecutionContext;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class Function {
    @FunctionName("mongo")
    public String mongo(@HttpTrigger(name = "req", methods = {"get", "post"}, authLevel = AuthorizationLevel.ANONYMOUS) String req,
                    ExecutionContext context) {

    try {
        MongoClientURI uri = new MongoClientURI("***");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("db");
        return String.format("Hello, I get database name : %s!", database.getName());

    } catch (Exception e) {
        e.printStackTrace();
        return "Access Error!";
    }
}