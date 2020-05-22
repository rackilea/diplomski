ArrayList<String> foundValues = new ArrayList<String>();
            ArrayList<String> jsonStringValues= new ArrayList<String>();
            jsonStringValues.add("Id");
            jsonStringValues.add("Available_Ambient_MT__c");
            jsonStringValues.add("Available_MT__c");
            jsonStringValues.add("Measurement__c");

            JSONObject jObj = yourItems.getJSONObject(i);
            for(String node: jsonStringValues){
               if(jObj.getString(node).equals("Photorec")){
                  foundValues.add(node);
               } 
            }
            System.out.println("Values found: " + foundValues);