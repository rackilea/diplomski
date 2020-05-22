HashMap<String, Integer> map = new HashMap<String, Integer>();

 for(String mainString: stringList){
      map.put(mainString, 1); 
   }

 for (SomeObject obj : objectList) {
      List<SecondaryObject> secobjList = obj.getSecList();
      for (SecondaryObject secObj : secObjList) {
          if (map.get(secObj.str) != null) {
              log.log("Found a match");
          }
      }
 }