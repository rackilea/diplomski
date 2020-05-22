public Map<String, Map<String, Clausula>> deepCopy(Map<String, Map<String, Clausula>> nvLista)
{
   Map<String, Map<String, Clausula>> target = new TreeMap<String, Map<String, Clausula>>();
   for (String key: nvLista.keySet()) {
       Map<String, Clausula> value = nvLista.get(key);
       target.put(key, new TreeMap<String,Clausula>(value));
   }
   return target;
}