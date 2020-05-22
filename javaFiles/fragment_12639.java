RevCommit latestCommit = null;
String path = "file.txt";
try( RevWalk revWalk = new RevWalk( git.getRepository() ) ) {
  Ref headRef = git.getRepository().exactRef( Constants.HEAD );
  RevCommit headCommit = revWalk.parseCommit( headRef.getObjectId() );
  revWalk.markStart( headCommit );
  revWalk.sort( RevSort.COMMIT_TIME_DESC );
  revWalk.setTreeFilter( AndTreeFilter.create( PathFilter.create( path ), TreeFilter.ANY_DIFF ) );
  latestCommit = revWalk.next();
}