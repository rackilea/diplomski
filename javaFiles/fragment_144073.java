int count = 0;
for(Object[] entityToCopy : entitiesToCopy){
   Entity entity= (Entity )entityToCopy[0];
   tmpValueForEntityId= lastEntryInEntityId ;
   queryString.append("("+ lastEntryInEntityId ++ 
      +","+entity.getProperty()+","+entity[1]+","+entity.getProperty2()+"),");

    for(Entity2 entity2 : entity.getEntity2Collection()){
        queryString2.append("("+lastEntryInEntity2Id ++ 
  +","+tmpValueForEntityId+","+entity.getProperty2()+","+entity.getProperty3()+"),");
    }
   count++;
   if(count%2000 == 0 || entitiesToCopy.size() == count){
       em.executeQuery(queryString);
       queryString = "";
       em.executeQuery(queryString2);
       queryString2 = "";
   }
}