public SearchFilters getFilters() {
if(getSession().get("Filters") == null){
  //How to set the values
  getSession().put("Filters", new Filters()); 
}
// and return.
 return (SearchFilters) getSession().get("Filters");
}