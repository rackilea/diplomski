public String[] getCurrentActivity(String testHarnessSensor) {
LOGGER.log(Level.INFO, "Attempting to get activity.");
ArrayList<String> currentActivity = new ArrayList<String>();
try {
  ...
  while (jsonReader.hasNext()) {
    ...                           
      while (jsonReader.hasNext()) {
        ...                        
        while (jsonReader.hasNext()) {                   
          String n = jsonReader.nextName();
          n = jsonReader.nextString();                   
          if (testHarnessSensor.equals(n)) {              
            currentActivity.add(activityName);
          }
        }
        ...
}
catch (Exception e) {
  System.out.println(e);
}
return currentActivity.toArray();