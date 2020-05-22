@org.junit.Test
public void test() {
 List<String> names = Arrays.asList("George", "John", "Paul", "Ringo");
 assertEquals("George, John, Paul and Ringo", StringUtils.asLiteralNumeration(names));

 List<String> oneItemList = Arrays.asList("Paul");
 assertEquals("Paul", StringUtils.asLiteralNumeration(oneItemList));

 List<String> emptyList = Arrays.asList("");
 assertEquals("", StringUtils.asLiteralNumeration(emptyList));

}