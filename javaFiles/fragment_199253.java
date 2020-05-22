List<String> items = Arrays.asList("a","b","c");

// Using Guava
String guavaVersion = Joiner.on(", ").join(items);

// Using Commons / Lang
String commonsLangVersion = StringUtils.join(items, ", ");

// both versions produce equal output
assertEquals(guavaVersion, commonsLangVersion);