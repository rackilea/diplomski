JSONObject jsonObject= new JSONObject();  
jsonObject.put("Number", address.getNumber());  
jsonObject.put("Make", address.getMake());  
jsonObject.put("Model", address.getModel());  
jsonObject.put("Description", address.getDescription());  
jsonObject.put("Plates", address.getPlates());  
final String requestBody=jsonObject.toString();