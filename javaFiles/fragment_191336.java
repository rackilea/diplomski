String s = "{\"success\": true, ";
ObjectMapper om = new ObjectMapper();
s += "\"friends\": " + om.writeValueAsString(myList).replace('"', '\'') + ", ";
s += "\"count\": " + myList.size();
s += "}";
return s;