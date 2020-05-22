ArrayList<BasicDBObject> images = (ArrayList<BasicDBObject>)obj.get("images"); 
for(BasicDBObject image: images)
{
     String link = image.getString("link");
     .......
}