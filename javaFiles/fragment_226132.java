TreeWalk treeWalk = new TreeWalk( repository );
treeWalk.setRecursive( true );
treeWalk.addTree( commit.getTree() );
while( treeWalk .next() ) {
  if( !isBinary( treeWalk ) {
    filesToArchive.add( treeWalk.getPathString() );
  }
}
treeWalk.close();