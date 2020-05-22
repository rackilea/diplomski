tabs.addListener( (Change<? extends Tab> change) -> {
  while( change.next() ) {
    if( change.wasAdded() ) {
      for( final Tab tab : change.getAddedSubList() ) {
        System.out.println( "Tab Added: " + tab );
      }
    } else if( change.wasRemoved() ) {
      // ...
    }
  }
} );