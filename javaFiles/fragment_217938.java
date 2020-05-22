String[] strArray = str.split(",");
for(String string : strArray) {
   if (!tc.containsValue(string)) {
          temp=temp + string + ", ";
          tc.put(Integer.parseIn(string), string);
   }
}