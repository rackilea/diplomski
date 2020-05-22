@Test
public void transactionsAreIsolated() {
  try (Handle h1 = jdbi.open();
       Handle h2 = jdbi.open()) {
    h1.begin();
    h2.begin();

    assertThat(count(h1)).isEqualTo(0); 
    assertThat(count(h2)).isEqualTo(0); // locks h2's txn to the current snapshot

    insert(h1, 1, 1);

    assertThat(count(h1)).isEqualTo(1);
    assertThat(count(h2)).describedAs("read uncommitted").isEqualTo(0);

    h1.commit();

    assertThat(count(h1)).isEqualTo(1);
    assertThat(count(h2)).describedAs("read committed").isEqualTo(0);

    h2.rollback();
  }
}