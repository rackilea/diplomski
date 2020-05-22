lookup = [];
queue = [ { 123456789, 0 } ]:

while( there is a node in the queue ) {

  take the first node out of the queue

  // skip nodes we already processed
  if( !(node in lookup) ) {

    generate all permutations possible by using 1 rotation starting form node
      push all generated nodes to the queue using a distance + 1
  }
}