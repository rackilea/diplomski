private List<SelectItem> domains;
private Configuration config = new PropertiesConfiguration("prop.properties"); // with accessors

public List<SelectItem> getDomains(){
  domains = new ArrayList<SelectItem>();
  String[]  domainSelection = getConfig().getStringArray("domain");
  for(String domain : domainSelection ){
     //Define desired logic for the value if its the same (.com) pass the same as value
     domains.add( new SelectItem(domain ,domain)); // SelectItem(value, label);
  }
  return domains;
}