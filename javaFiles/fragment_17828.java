RevWalk walk = new RevWalk( repository )
walk.setRevFilter( RevFilter.NO_MERGES )
walk.setTreeFilter( AndTreeFilter.create( PathFilterGroup.create( pathFilter ) );

walk.sort( RevSort.COMMIT_TIME_DESC, true );
walk.markStart( walk.parseCommit( repository.resolve( "refs/heads/branch-name" ) );
if( walk.next() != null ) {
  // now the RevWalk points to the newest commit in which the 
  // file was modified in the branch, excluding merges.
}

walk.close();