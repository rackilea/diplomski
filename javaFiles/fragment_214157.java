Pattern path = Pattern.compile("Programing");
          BasicDBObject query = new BasicDBObject();
          query.put("Path", path);

          DBCursor doc = example.find(query ); 

          while(doc.hasNext())
          {                    
            System.out.println(doc.next());
          }