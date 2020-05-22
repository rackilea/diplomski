...
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    PrintWriter out = resp.getWriter();
    Document doc =
        Document.newBuilder()
            .setId("theOnlyPiano")
            .addField(Field.newBuilder().setName("product").setText("cats and dogs"))
            .addField(Field.newBuilder().setName("maker").setText("Yamaha"))
            .addField(Field.newBuilder().setName("price").setNumber(4000))
            .build();
    try {
      Utils.indexADocument(SEARCH_INDEX, doc);
    } catch (InterruptedException e) {
      // ignore
    }
    // [START search_document]
    final int maxRetry = 3;
    int attempts = 0;
    int delay = 2;
    while (true) {
      try {
        String searchText = "cat";
        String queryString = "product = ~"+searchText;
        Results<ScoredDocument> results = getIndex().search(queryString);

        // Iterate over the documents in the results
        for (ScoredDocument document : results) {
          // handle results
          out.print("product: " + document.getOnlyField("product").getText());
          //out.println(", price: " + document.getOnlyField("price").getNumber());
        }
      } catch (SearchException e) {
        if (StatusCode.TRANSIENT_ERROR.equals(e.getOperationResult().getCode())
            && ++attempts < maxRetry) {
          // retry
          try {
            Thread.sleep(delay * 1000);
          } catch (InterruptedException e1) {
            // ignore
          }
          delay *= 2; // easy exponential backoff
          continue;
        } else {
          throw e;
        }
      }
      break;
    }
    // [END search_document]
    // We don't test the search result below, but we're fine if it runs without errors.
    out.println(" Search performed");
    Index index = getIndex();
    // [START simple_search_1]
    index.search("rose water");
    // [END simple_search_1]
    // [START simple_search_2]
    index.search("1776-07-04");
    // [END simple_search_2]
    // [START simple_search_3]
    // search for documents with pianos that cost less than $5000
    index.search("product = ~cat AND price < 5000");
    // [END simple_search_3]
  }
}