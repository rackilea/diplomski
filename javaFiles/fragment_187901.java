Iterator<Book> iterator = bookList.iterator();
    while(iterator.hasNext()){
      Book c = iterator.next();
      if(c.getBookName().startsWith(name)){
                jsonObjec=new JSONObject();
                jsonObjec.put("label",c.getBookName());
                jsonObjec.put("value", c.getId());
                jsonArr.add(jsonObjec);
        }
    }