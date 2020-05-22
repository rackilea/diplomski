private static void assertEntryEquals(Entry<List<int[]>, Enum<?>> entry, List<int[]> key, Enum<?> value) {
    assertThat(entry.getValue(), is(value));
    Iterator<int[]> original = entry.getKey().iterator();
    for (int[] expected : key) assertArrayEquals(original.next(), expected);
    assertFalse(original.hasNext());
}