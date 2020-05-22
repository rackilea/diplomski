HashMap<String,AgentSales> aggregate = new HashMap<>();
for (AgentSales as : salesList) {
   String key = as.getAgent() + as.getMonth() + as.getYear();
   AgentSales existing = aggregate.get(key);
   if (existing==null) {
      aggregate.put(key,as);
      continue;
   }
   AgentSales combined = new AgentSales(as.getAgent(), as.getMonth(), as.getYear(), as.getSalesCount()+exisgint.getSalesCount());
   aggregate.put(key, combined); 
}