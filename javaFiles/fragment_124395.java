public Map<String,String> getDomainProperties(Map map, String domainName) {
   if (!map.containsKey("domain") {
      return null; // or throw an exception if you prefer.
   }
   Map domainMap = map.get("domain");
   if (!domainMap.containsKey(domainName)) {
      return null; // or throw IllegalArgumentException or similar if you prefer
   }

   return (Map<String,String>) domainMap.get(domainName);
}