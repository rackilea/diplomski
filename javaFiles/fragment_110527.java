// Approach 1
Map<String, Object> read = JsonPath.read(json, "$");

assertThat(read.size(), is(2));

assertThat(read.keySet(), hasItem("tool"));
assertThat(read.keySet(), hasItem("book"));

// Approach 2: if you want a String[] then ...
String[] rootNodeNames = read.keySet().toArray(new String[read.size()]);
assertThat(rootNodeNames, Matchers.both(arrayWithSize(2)).and(arrayContainingInAnyOrder("book", "tool")));

// Approach 3: if you want to hide it all behind the hasJsonPath() matcher
// note: each of these assertion will cause your JSON string to be parsed 
// so it's more efficient to do that once and assert against the 
// resulting map as I did above
assertThat(json, hasJsonPath("$", Matchers.hasKey("tool")));
assertThat(json, hasJsonPath("$", Matchers.hasKey("book")));