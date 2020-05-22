while (cursorEvents.hasNext()) 
  {
        DBObject doc1 = cursorEvents.next();
        if(cursorEvents.hasNext())
        {
            DBObject doc2 = cursorEvents.next();
        }

        if("mouseMove".equals(documentInEventCollection.get("type"))){ 

        System.out.println("offscreen(" + x_and_y + "): " + doc1.get("offScreen").toString()+","+doc2.get("offScreen").toString());
        x_and_y++;                                      
        }