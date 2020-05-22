class Item {
  boolean checked;
  String name;
}

class CheckList {
  private final int maxItemsAllowed;
  private final List<Item> items;

  public CheckList( int maxItems ) {
    maxItemsAllowed = maxItems;
    items = new ArrayList<>( maxItemsAllowed  );
  }



  public void addItem( Item i ) {
    if( items.size() >= maxItemsAllowed ) {
      throw new IllegalArgumentException("Maximum no. of allowed items (" + maxItemsAllowed + ") exeeded");
    }

    items.add( i );
  }
}