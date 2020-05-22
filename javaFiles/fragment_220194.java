List<List<? extends Number>> lolAnyNum = new ArrayList<List<? extends Number>>();

lolAnyNum.add(new ArrayList<Integer>());
lolAnyNum.add(new ArrayList<Float>());
// lolAnyNum.add(new ArrayList<String>());     // DOES NOT COMPILE!!

// lolAnyNum = new ArrayList<List<Integer>>(); // DOES NOT COMPILE!!

List<? extends List<? extends Number>> lolSomeNum;

lolSomeNum = new ArrayList<List<Integer>>();
lolSomeNum = new ArrayList<List<Float>>();
// lolSomeNum = new ArrayList<List<String>>(); // DOES NOT COMPILE!!