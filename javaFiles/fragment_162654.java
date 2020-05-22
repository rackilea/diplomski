String id = request.getParameter("id");

    int x = 0;
    if(id!=null){
      try{
        x = Integer.parseInt(id);
       }catch(Exception e){
       }

    }