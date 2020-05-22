public class MockCountFetcher extends CountFetcher {
  @Override
  getCount1() { return mockCount1; }
}

public class TestCounter {
  @Test
  public void smokeTest() {
    CountFetcher mockFetcher = new MockCountFetcher();
    Counter counter = new Counter(mockFetcher);
    assertEquals(someExpectedValue, counter.getCounts());
  }
}