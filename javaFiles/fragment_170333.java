String text = "012ab567ab0123ab";

// finding all occurrences forward: Method #1
for (int i = text.indexOf("ab"); i != -1; i = text.indexOf("ab", i+1)) {
    System.out.println(i);
} // prints "3", "8", "14"

// finding all occurrences forward: Method #2
for (int i = -1; (i = text.indexOf("ab", i+1)) != -1; ) {
    System.out.println(i);
} // prints "3", "8", "14"