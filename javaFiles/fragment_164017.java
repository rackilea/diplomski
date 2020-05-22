public class SearchLayer1 {
  // ...
  private DirectoryReader directoryReader;
  private IndexSearcher indexSearcher;

  public SearchLayer1() throws IOException {
    // ...
    this.directoryReader = DirectoryReader.open(indexWriter, false);
    this.indexSearcher = new IndexSearcher(directoryReader);
  }

  // ...

  private void refreshReader() throws IOException {
    DirectoryReader newReader = DirectoryReader.openIfChanged(this.directoryReader);
    if (newReader != null && newReader != this.directoryReader) {
      this.directoryReader.close();
      this.directoryReader = newReader;
      this.indexSearcher = new IndexSearcher(this.directoryReader);
    }
  }

  public void experiment() throws IOException {
    refreshReader();
    IndexSearcher isearcher = this.indexSearcher;
    // ...
  }

  public void close() throws IOException {
    directoryReader.close();
    // ...
  }
}