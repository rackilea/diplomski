try{
  Base.openTransaction(); 
  chain.doFilter(request,wrapper);
  Base.commitTransaction(); 
}catch(Exception e){
  // log exception
  Base.rollbackTransaction();
}finally{
  Base.close();
}