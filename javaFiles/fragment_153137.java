System.out.println(Pattern.matches("[^|]", "")); // false
System.out.println(Pattern.matches("[^|]", "a")); // true
System.out.println(Pattern.matches("[^|]", "aaa")); // false
System.out.println(Pattern.matches("[^|]*", "")); // true
System.out.println(Pattern.matches("[^|]*", "aaa")); // true
System.out.println(Pattern.matches("[^|]*", "a|a")); // false