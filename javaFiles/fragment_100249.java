@Test
public void test() {
    Map<String, Object> map1 = new HashMap<>();
    map1.put("foo1", "foo1");
    map1.put("foo2", Arrays.asList("foo2", "bar2"));

    assertThat(map1, hasEntry("foo1", "foo1"));
    assertThat(map1, hasListEntry(is("foo2"), containsInAnyOrder("foo2", "bar2")));
}

@SuppressWarnings("unchecked")
public static org.hamcrest.Matcher<java.util.Map<String, Object>> hasListEntry(org.hamcrest.Matcher<String> keyMatcher, org.hamcrest.Matcher<java.lang.Iterable<?>> valueMatcher) {
    Matcher mapMatcher = org.hamcrest.collection.IsMapContaining.<String, List<?>>hasEntry(keyMatcher, valueMatcher);
    return mapMatcher;
}