@Test
  void name2() throws Exception {
    final Object obj = new Object();

    Single<Object> just1 = Single.just(obj);
    Single<Object> just2 = Single.just(obj);

    Object value1 = just1.toBlocking().value();
    Object value2 = just2.toBlocking().value();

    assertThat(value1).isEqualTo(value2);
  }