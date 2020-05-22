Map<String,Object> row = data.get(0);
String one  = (String)row.get("one");

//these will not work -- Integer, Double incompatible with String
/* int two     = ((Integer)row.get("two")).intValue();
double four = ((Double)row.get("four")).doubleValue(); */

//correct method
int two     = Integer.parseInt((String)row.get("two"));
double four = Double.parseDouble((String)row.get("four"));

char three  = ((Character)row.get("three")).charValue();
    String five = (String)row.get("five");