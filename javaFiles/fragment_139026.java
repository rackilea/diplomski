String foo = "foo";
StringBuffer str = new StringBuffer("foofoo");
StringBuffer str2 = new StringBuffer("foo");
foo.contains(str); // true
foo.contentEquals(str) // false
foo.contentEquals(str2) // true