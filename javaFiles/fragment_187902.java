List list = new ArrayList<>();
     for(Book c:GlobalObjects.bookList){
        if(c.getBookName().startsWith(name)){
                jsonObjec=new JSONObject();
                jsonObjec.put("label",c.getBookName());
                jsonObjec.put("value", c.getId());
                list.add(jsonObjec);//java.util.ConcurrentModificationException
        }
     }
     jsonArr.addAll(list);