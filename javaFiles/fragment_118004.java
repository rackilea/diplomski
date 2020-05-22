DirCache index = repository.lockDirCache();
try {
  // create treeWwalk
  treeWalk.addTree( new DirCacheIterator( index ) )
  // iterate over treeWalk
} finally {
  index.unlock();
}