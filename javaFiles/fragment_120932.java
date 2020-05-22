SharedPreferences preferences=this.getSharedPreferences("com.example.application", Context.MODE_PRIVATE);
Map<String,?> keys = preferences.getAll();
Properties properties = new Properties();
for(Map.Entry<String,?> entry : keys.entrySet()){
    String key = entry.getKey();
    String value = entry.getValue().toString();
    properties.setProperty(key, value);      
}
try {
    File file = new File("externalPreferences.xml");
    FileOutputStream fileOut = new FileOutputStream(file);
    properties.storeToXML(fileOut, "External Preferences");
    fileOut.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}