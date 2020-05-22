public Map<Integer, PubModule> getModules() {
   if (modules == null) {
      modules = new PubModulesMap();
   } else if (!(modules instanceof TreeMap)) {
      modules = new TreeMap(modules); // Or new PubModulesMap(modules)
   }
   return modules;
}