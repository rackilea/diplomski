for(firstObject fo : list1)
  {  
     Object so = map.get(fo.getUserId());  
     if(null!=so)
       {  
         fo.setName(so.getName());  
         fo.setEmail(so.getEmail());  
       }  
  }