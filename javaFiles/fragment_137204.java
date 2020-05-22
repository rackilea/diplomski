Document found = database.getCollection("rss_feed").find(fields).first();
    if (found == null) { 
    collection.insertOne(fields); 
    mongoClient.close(); 
    System.out.println("Feed not exists in database. Written."); 
    } else { 
    System.out.println("Feed exists in database.");
     mongoClient.close(); 
    }