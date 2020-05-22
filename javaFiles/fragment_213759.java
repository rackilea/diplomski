Map<String, Double> assemblyDupMap = new HashMap<>();
for (Iterator<Assembly> it = assemblies.iterator(); it.hasNext(); ){
      Assembly a = it.next();
      if(!assmCode.add(a.getAssemblyCode())){ 
         // store the duplicate information 
         double currentQty = assemblyDupMap.getOrDefault(a.getAssemblyCode(), 0D);
         assemblyDupMap.put(a.getAssemblyCode(), currentQty + a.getAssemblyQty()); 
         // remove it from the list
         it.remove();        
      }

};