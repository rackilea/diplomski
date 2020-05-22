import org.apache.lucene.search.SearcherManager;
// ...

public class SearchLayer1 {
  // ...
  private final SearcherManager searcherManager;

  public SearchLayer1() throws IOException {
    // ...
    this.searcherManager = new SearcherManager(indexWriter, false, null);
  }

  // ...

  public void experiment() throws IOException {
    searcherManager.maybeRefresh();
    IndexSearcher isearcher = searcherManager.acquire();
    try {
      // ...
    } finally {
      searcherManager.release(isearcher);
    }
  }

  public void close() throws IOException {
    searcherManager.close();
    // ...
  }
}