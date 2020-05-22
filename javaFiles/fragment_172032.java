//Get the json serialization of the task object
GsonBuilder builder = new GsonBuilder();
//builder.setPrettyPrinting().serializeNulls(); //optional
Gson gson = builder.create();
String json = gson.toJson(task);  
try {  
   //write json string to a file named "/tmp/task.json"  
   FileWriter writer = new FileWriter("/tmp/task.json");  
   writer.write(json);  
   writer.close();  
} catch (IOException e) {e.printStackTrace();}