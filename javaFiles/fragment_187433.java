while (jsonReader.hasNext()) {                    
                  String activityAttribute = jsonReader.nextName();
                  String n = jsonReader.nextString();                 
                  if (testHarnessSensor.equals(n)) {                 
                    currentActivity.put(activityName, activityAttribute);
                  }
                }