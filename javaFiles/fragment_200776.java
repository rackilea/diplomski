List<Person> returnList = new ArrayList<Person>();
while (cursor.hasNext()) { 
    DBObject obj = cursor.next(); 
    Person person = mongoTemplate.getConverter().read(Person.class, obj);  
    returnList.add(person); 
}