Gson gson = new GsonBuilder().create(); 
JsonObject job = gson.fromJson(fileReader, JsonObject.class); 
JsonObject ovl = job.getAsJsonObject("overlays");
Map<String, Object> data = new Gson().fromJson(ovl, type); 
Iterator<String> entries = data.keySet().iterator(); 
while (entries.hasNext()) 
{ JsonObject overlay = ovl.getAsJsonObject(entries.next().toString()); 
   if (overlay != null)
     { 
       osb.setOverlay(jsp.getOverlay(overlay));
     }
 }