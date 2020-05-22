// with Iterables:

Iterable<String> iterableStrings = getListOfStrings();

// standard for loop
for (Iterator<String> it = iterableStrings.iterator(); it.hasNext(); ) {
   String s = it.next();
   System.out.println(s);
}

// enhanced for loop
for (String s : iterableStrings) {
   System.out.println(s);
}

// with arrays:

String[] stringArray = getStringArray();

// standard for loop
for (int i = 0; i < stringArray.length; i++) {
   String s = stringArray[i];
   System.out.println(s);
}

// enhanced for loop
for (String s : stringArray) {
   System.out.println(s);
}