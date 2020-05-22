Gson gson = new Gson();
    Type type = new TypeToken<List<MyObject>>(){}.getType();
    List<MyObject > objList = gson.fromJson(str, type);


    assert(objList != null);  // validate not null

    for(MyObject obj : objList){

        System.out.println("id=" + obj.id + "; name=" + obj.name);
    }