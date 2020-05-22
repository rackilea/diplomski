public static void main(String[] args)   {

String json ="{\"Peter\":{\"id\":585897,\"name\":\"PhPeter\",\"profileIconId\":691,\"age\":99,\"email\":\"peter@adress.com \"}}";
Gson gson = new Gson();  
StringReader reader = new StringReader(json);
   //convert the json string back to object  
Object obj = gson.fromJson(reader, Object.class);  
if(obj instanceof Map){
    Map map =(Map)obj;
    Collection coll = map.values();
    Iterator iter = coll.iterator();
    while(iter.hasNext()){
         Object str = iter.next();

        StringReader sr = new StringReader(str.toString());
        Member memberObj = gson.fromJson(sr, Member.class); 
     System.out.println("Id: " + memberObj.getId());  
     System.out.println("Name: " + memberObj.getName());  
     System.out.println("ProfileIconID: " + memberObj.getProfileIconId());  
     System.out.println("Age: " + memberObj.getAge());  
     System.out.println("Email: " + memberObj.getEmail());  
    }

}

    }