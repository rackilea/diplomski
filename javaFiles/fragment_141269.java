public void map(Map<String, Object> document, Emitter emitter) {
  if (document.get("type") != null && document.get("type").equals("mytype")) {
                            List<Object> keys = new ArrayList<Object>();    
                            //order of elements have been changed                        
                            keys.add(document.get("relatedObjectId"));
                            keys.add(document.get("dateCreated");
                            emitter.emit(keys, null);
   }
}