JSONArray jr = new JSONArray("myjsonstring");
     for(int i=0;i<jr.length();j++)
     {
     JSONOBject jb = jr.getJSONObject(i);
     String uid = jb.getString("uid");
     String status = jb.getString("status");
     String name = jb.getString("name");  
     }