FileBackedList<String> list = new FileBackedList<String>();

// This will probably serialise the String "abc" to your file
list.add("abc");

// This will not work. <V> is always String for FileBackedList<String>
list.add(Integer.valueOf(1));

// This will be type-safe. It can only be String because you bind V to String
String abc = list.get(0);