findCustomer.put("email", custEmail); // search query for the customer email

// construct your newAddress object the same way you already are

BasicDBObject custMod = new BasicDBObject();
custMod.put("$addToSet", newAddress);
customerCollection.update(findCustomer, custMod, true /* upsert */, false /* multi */ );