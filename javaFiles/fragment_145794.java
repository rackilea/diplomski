String[][] expected = new String[][] { { "A", "B", "C" }, { "A", "B", "C" } };

Object[] expectedLists = Arrays.stream(expected).map(Arrays::asList).toArray();

String[] actual = new String[] { "A", "B", "C" };

assertThat(Arrays.asList(actual), isIn(expectedLists));