if (!holderMap.isEmpty()) {
  clientId = holderMap.get("abc") == null ? 
             holderMap.get("pqr") == null ? 
             holderMap.get("def") == null ? 
             null : holderMap.get("def") : holderMap.get("pqr") : holderMap.get("abc");
}