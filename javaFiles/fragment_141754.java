try {

        modelclass obj;
         /*Some Text*/

        while (srs.next()) {
           obj= new modelclass();

             obj.setEmailid(srs.getString("email_id"));
            obj.setPwd(srs.getString("pwd"));
            arraylist.add(obj);  //i++;
        }
        model.addObject("arraylist", arraylist);