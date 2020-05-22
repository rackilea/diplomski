List<Items> batch = new ArrayList<>();
final ScrollableResults results = session.createQuery( ... ).scroll();
while ( results.next() ) {
  batch.add( results.get( 0 ) );
  if ( ( batch.size() % 100 ) == 0 ) {
    reindexer.reindex( batch, ReindexerPriority.LOW );
    batch.clear();
    session.clear();
  }
}

// handle left-overs of < 100 on last batch to process.
if ( !batch.isEmpty() ) {
 reindexer.reindex( batch, ReindexerPriority.LOW );
 batch.clear();
 session.clear();
}