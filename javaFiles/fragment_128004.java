// You want this line contains only Integer.
List list = new ArrayList<>();

// 1. Warning when add new item.
list.add(1);
list.add(2);
list.add(3);

// 2. Must cast to Integer when using.
Integer number2 = (Integer) list.get(1);

// 3. Do not prevent developers from adding non-integer type, such as String, double, boolean etc.
list.add("Four");
list.add(true);

// 4. Might throws ClassCastException and make your app crashes.
Integer number = (Integer) list.get(4);