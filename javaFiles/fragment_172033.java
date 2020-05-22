Gson gson = new Gson();  
try {  
    BufferedReader br = new BufferedReader(new FileReader("/tmp/task.json"));  
    //convert the json string from file back to object  
    Task task = gson.fromJson(br, Task.class);  
} catch (IOException e) {  
   e.printStackTrace();  
}