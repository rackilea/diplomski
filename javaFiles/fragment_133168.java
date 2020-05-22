String s = "hello";
s = "World"; // the reference s changes, not the String.

final String t = "Hi"; // immutable reference
t = "there"; // won't compile.

// immutable reference to a mutable object.
final StringBuilder sb = new StringBuilder();
sb.append("Hi"); // changes the StringBuilder but not the reference to it.
sb = null; // won't compile.