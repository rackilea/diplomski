public static void main(String[] args) {
        Gson gson = new Gson();  

        try {   

            BufferedReader br = new BufferedReader(new FileReader("src/Members.json"));  //path to your file


            Object obj = gson.fromJson(br, Object.class);
            if (obj instanceof Map) {
                Map map = (Map) obj;
                Collection coll = map.values();    
                Iterator iter = coll.iterator();
                JsonParser parser = new JsonParser();
                while (iter.hasNext()) {

                    Object str = iter.next();
                  JsonArray jsonArr = parser.parse(str.toString()).getAsJsonArray();
                    for(int i=0;i<jsonArr.size();i++){

                    Member memberObj = gson.fromJson(jsonArr.get(i).toString(), Member.class);
                    System.out.println("Id: " + memberObj.getId());
                    System.out.println("Name: " +memberObj.getName());
                    System.out.println("ProfileIconID: " + memberObj.getProfileIconId());
                    System.out.println("Email: " + memberObj.getEmail());
                    System.out.println("Age: " + memberObj.getAge());
                    }
                } 

            } 
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }