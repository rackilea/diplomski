List<List<?>> lolAny = new ArrayList<List<?>>();

lolAny.add(new ArrayList<Integer>());
lolAny.add(new ArrayList<String>());

// lolAny = new ArrayList<List<String>>(); // DOES NOT COMPILE!!

List<? extends List<?>> lolSome;

lolSome = new ArrayList<List<String>>();
lolSome = new ArrayList<List<Integer>>();