Cursor currentViewCursor = aJPanel.getCursor();

 assertCursorsEquals(currentViewCursor, myListenerClass.getCursorForIcon(iconName));

}

private void assertCursorsEquals( Cursor a, Cursor b){
  assertEquals(a.getType(), b.getType());
  ...//other checks you care about

}