class Animal {

      Map<String, Object> data = new HashMap <String, Object>();

      public void setValue(Map<String, Object> map)
       {
         this.data = map;
       }
      public Map<String, Object> getValue()
       {
        return this.data;
       }
    }

class Dog extends Animal {

      public void index()
      { 
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "Tommy");
        map.put("favfood", "milk"); // want to pass Lists, Integers also
        setValue(map);
      }
    }