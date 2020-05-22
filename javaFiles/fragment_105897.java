public class Counter {
  private final CountFetcher fetcher; 

  public Counter(CountFetcher fetcher) { 
    this.fetcher = fetcher;
  }

  public getCounts() {
    Promise<Integer> count1 = fetcher.getCount1();
    Promise<Integer> count2 = fetcher.getCount2();
    ...
  }
}