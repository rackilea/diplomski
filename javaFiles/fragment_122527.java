String innerQuery = "select barcode from Data where barcode is not null";
List<String> innerResults = getHibernateTemplate().find(innerQuery);
List<String> results = new ArrayList<String>();
for(String barocde : innerResults){
    results.add("'" + barcode + "'");
}
if(!results.isEmpty()){
   String outerQuery = "from Data d where d.barcode in (" +
   results.toString().replace("[", "").replace("]", "") + ")";
   return getHibernateTemplate().find(outerQuery);
}