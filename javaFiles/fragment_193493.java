// this finds all documents in a given collection (note: no parameter supplied to the find() call) 
    // and for each document it projects on Project_Information.Project_Description
    FindIterable<Document> documents =
            mongoClient.getDatabase("...").getCollection("...")
               .find()
               // for each attrbute you want to project you must include its dot notation path and the value 1 ... 
               // this is the equivalent of specifying {'Project_Information.Project_Description': 1} in the MongoDB shell
               .projection(new Document("Project_Information.Project_Description", 1));

    for (Document document : documents) {
        // the response contains a sub document under the key: "Project_Information"
        Document projectInformation = (Document) document.get("Project_Information");
        // the "Project_Description" is in this sub document
        String projectDescription = projectInformation.getString("Project_Description");

        // prints "Sample"
        System.out.println(projectDescription);

        // to return this single String value in an Object[] (as implied by your OP) just do create the Object[] like this and then return it ...
        Object[] r = new Object[] {projectDescription};

        // prints the entire projected document e.g. { "_id" : { "$oid" : "59db2321811a592384865711" }, "Project_Information" : { "Project_Description" : "Sample" } }
        System.out.println(document.toJson());
    }