git.commit().setMessage( "base" ).call();
String master = git.getRepository().getFullBranch();
Ref side = git.branchCreate().setName( "side" ).call();
git.commit().setMessage( "master" ).call();
git.checkout().setName( side.getName() ).call();
git.commit().setMessage( "side" ).call();
git.merge().include( git.getRepository().getRef( master ) ).setFastForward( NO_FF ).setMessage( "merge" ).call();

try( RevWalk revWalk = new RevWalk( git.getRepository() ) ) {
  revWalk.setRevFilter( AndRevFilter.create( new FirstParentFilter(), RevFilter.NO_MERGES ) );
  revWalk.sort( RevSort.TOPO );
  Ref headRef = git.getRepository().getRef( Constants.HEAD );
  RevCommit headCommit = revWalk.parseCommit( headRef.getObjectId() );
  revWalk.markStart( headCommit );
  for( RevCommit revCommit : revWalk ) {
    System.out.println( revCommit.getShortMessage() );
  }
}