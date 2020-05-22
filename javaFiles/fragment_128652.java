List<String> keyElementList = new ArrayList<String>;

BasicDBList bDBList = (BasicDBList)basicDBObject.get("key_elements");

for(int i = 0; i < bDBList.size(); ++i){
    keyElementsList.add((String)bDBList.get(i));
}