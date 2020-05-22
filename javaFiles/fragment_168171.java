// somewhere out there
public enum Events {
  TERMINATE, DO_SOMETHING, BAKE_SOMETHING
}

// inside consumer
Events e;
while( (e = queue.take()) != TERMINATE ) {
  switch(e) {
    case DO_SOMETHING:
      // blah blah
  }
}

// somewhere else in another thread
Events e = BAKE_SOMETHING;
if( queue.offer(e) )
   // the queue gladly accepted our BAKE_SOMETHING event!
else
   // oops! we could block with put() if we want...