void forEachLoop(){
  //          v--- create a new Iterator when forEachLoop was called.
  for(T item:items);
}

void forEach(){
                // v--- create a single lambda instance.
  items.forEach(it->{});
}