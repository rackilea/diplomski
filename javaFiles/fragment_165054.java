ResultEntry<Number>  numEntry  = ResultEntry.newInstance("", 5);
ResultEntry<Boolean> boolEntry = ResultEntry.newInstance("", true);
ResultEntry<String>  strEntry  = ResultEntry.newInstance("", "Foo");

Number  numInfo  = numEntry.getInfo();
Boolean boolInfo = boolEntry.getInfo();
String  strInfo  = strEntry.getInfo();