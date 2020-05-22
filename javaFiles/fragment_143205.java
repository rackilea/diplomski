List<BasicDBObject> andQuery2 = new ArrayList<BasicDBObject>();
                andQuery2.add(new BasicDBObject("id", id));
                andQuery2.add(new BasicDBObject("termsrelation.rel", relation));
                andQuery2.add(new BasicDBObject("termsrelation.terms.name", name));

                BasicDBObject searchObj2 = new BasicDBObject();
                searchObj2.put("$and", andQuery2);

                BasicDBObject basicDBObject = new BasicDBObject();
                basicDBObject.put("sourceType", type);
                basicDBObject.put("source", source);                


                BasicDBObject updateQuery = new BasicDBObject();
                updateQuery.append("$push", new BasicDBObject().append("termsrelation.$.terms."+position+".scopeNote", basicDBObject));


                coll.update(searchObj2, updateQuery).getError();