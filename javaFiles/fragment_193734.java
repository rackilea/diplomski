int page = 1;
for ( List<Items> items = getItemsByPage( page, 100 ); !items.isEmpty(); ++page ) {
  reindexer.reindex( items, ReindexerPriority.LOW );
  // make sure to clear the session to avoid out of memory with L1C
  session.clear();
}