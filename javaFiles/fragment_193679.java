private void buildHistoryData() {
  if (isLogFileEmpty()) return;
  history.clear();

  Gson gson = new GsonBuilder().create();
  try {
    JsonStreamParser parser = new JsonStreamParser(new FileReader(LOG_FILE));
    while (parser.hasNext()) {
      final LogRowModel currentRow = gson.fromJson(parser.next(), LogRowModel.class);
      if (currentFilter == LogFilter.ALL) history.add(currentRow);
      else if (currentRow.getLevel().equalsIgnoreCase(currentFilter.getLevel()))
        history.add(currentRow);
    }
  } catch (Exception ex) {
    ex.printStackTrace();
  }
}