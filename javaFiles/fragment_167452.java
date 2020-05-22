String searchKey=form.getSearchKey();
    if(!searchKey.isEmpty()) //Check for empty or null string
       {
         // Decode the string using URLDecoder class from java.net package
         form.setSearchKey(URLDecoder.decode(searchKey, "UTF-8"));
       }