public String rescue() { 
          String out = "";
          for(String _key : newMap.keySet()) {
              out += heroname1 + " rescued " + _key + " " + newMap.get(_key) + "!\n"
          }
          return out;
   }