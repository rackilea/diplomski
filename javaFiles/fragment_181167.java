Iterator<Mypojaclass> itr = results.iterator();
while(itr.hasNext()){
   Mypojaclass item = itr.next();
   if("JD".equals(item.getType())){
      itr.remove();
   }
}