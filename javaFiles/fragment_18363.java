@Test
public void basicFlowTest() {
 given(1)
  .when("multiplying by 2", givenValue -> 2 * givenValue)
  .then("value should be even", whenValue -> whenValue % 2 == 0);
}

public void multiTypeFlowTest() {
 LocalDateTime localDateTime = LocalDateTime.now();
 DayOfWeek expectedDay = localDateTime.getDayOfWeek();

 given(localDateTime)
  .when("retrieving current day", date -> date.getDayOfWeek())
  .then("days should match", day -> expectedDay == day);
}

@Test
public void assertFlowTest() {
 Integer primeNumber = 17;
 given("a prime number", primeNumber)
  .when("finding dividers naively", number -> IntStream.rangeClosed(1, number)
   .boxed().filter(value -> number % value == 0).collect(Collectors.toList()))
  .then(dividers -> {
   assertEquals("should have two dividers", 2, dividers.size());
   assertEquals("first divider should be 1", 1, (int) dividers.get(0));
   assertEquals(String.format("first divider should be %d", primeNumber), primeNumber, dividers.get(1));
  });
}