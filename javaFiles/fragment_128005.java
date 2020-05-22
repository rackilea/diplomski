// You want this line contains only Integer.
List<Integer> list = new ArrayList<>();

// If you want to declare variable first
List<Integer> items;

// Then initialize
items = new ArrayList<>();

// 1. No warning when add new item.
items.add(1);
list.add(2);
list.add(3);

// 2. No need to cast to Integer.
Integer number2 = list.get(1);

// 3. Prevent developers from adding non-integer type, such as String, double, boolean etc.
list.add("Four"); // Error when compile
list.add(true); // Error when compile

// 4. You cannot add non-integer type and no need to cast so ClassCastException never occurs.
Integer number = list.get(2);