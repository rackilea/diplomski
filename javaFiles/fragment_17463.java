Another Way to to connect mongo db using java


    public static void main(String[] args) {

        Mongo mongo = new Mongo("localhost", 27017);
        DB db = mongo.getDB("mydb");// db name


         DBCollection collection = db.getCollection("test");
          BasicDBObject query = new BasicDBObject();
          BasicDBObject rmfld = new BasicDBObject();
         JSONArray jrr=new JSONArray();
         JSONObject jobj=new JSONObject();
         // query.put("name", "test");
          rmfld.put("_id", 0);

          try{
          DBCursor openCur = collection.find(query,rmfld);

            while (openCur.hasNext()) {
                jrr.put(openCur.next());
            }
            if(openCur!=null)
            {
                openCur.close();
            }
            System.out.println(jrr);
          }
            catch (Exception e) {
                // TODO: handle exception
            }

    }