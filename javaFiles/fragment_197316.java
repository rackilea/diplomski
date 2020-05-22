Object[] result = (Object[])query.uniqueResult(); int i = 0;
  quoteOwnerDetails= new String[result.length];
  for(Object obj : result){
     System.out.println(obj);
     quoteOwnerDetails[i] = obj.toString(); 
     i++;
  }