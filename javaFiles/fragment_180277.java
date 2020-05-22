while(cursor.hasNext())
    {

        BasicDBObject acc=(BasicDBObject) cursor.next();
        BasicDBList scores = (BasicDBList) acc.get("scores");
        for(int i=0;i<scores.size();i++)
        {
            BasicDBObject score = (BasicDBObject) scores.get(i);
            System.out.println(score.get("score"));
        }

    }