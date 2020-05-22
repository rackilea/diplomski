@Test
public void shouldReturnSumOfTotalAndSubscriptionSavings() {
    Class obj = new ClassA();
    obj.setTotal(10);
    obj.setSubcriptionSavings(12);

    Integer actual = obj.getTotalBeforeSubscription();

    assertThat(actual, is(22));
}