service.getFeed(cellFeedUrl, CellFeed.class);
for(CellEntry ce : cellFeed.getEntries()) {
  Cell cell = ce.getCell();
  if(cell.getRow() == 1 && cell.getCol() == 3) {
    System.out.println(cell.getDoubleValue());
  }
}