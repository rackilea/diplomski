CloseableIterator<Binary> iterator = binaries.closeableIterator();
    try {
        while(iterator.hasNext()){
        Binary bin= iterator.next();
        //do stuff
        bin.setChunk(null) //discard if not needed any more
       }
    } finally {
        // must always close our iterators otherwise connections to the database are held open
        iterator.close();
    }