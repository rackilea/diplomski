List<Number> numbers = new ArrayList<Number>();
Number n = 1;
numbers.add(n); // ok.
n = numbers.get(0); // ok
numbers.add(1); // ok.

List<? extends Number> numbers2 = new ArrayList<Double>();
numbers2.add(n); // not ok
n = numbers2.get(0); // ok

List<? super Number> numbers3 = new ArrayList<Serializable>();
numbers3.add(n); // ok
n = numbers3.get(0); // not ok.