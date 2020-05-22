@Test
public void transactionsLockToStateWhenObserved() {
  try (Handle h1 = jdbi.open();
       Handle h2 = jdbi.open()) {
    h1.begin();
    h2.begin();

    insert(h1, 1, 1);

    assertThat(count(h1)).isEqualTo(1);

    h1.commit();

    assertThat(count(h2))
        .describedAs("_now_ we're locked to a snapshot")
        .isEqualTo(1);

    h2.rollback();
  }
}