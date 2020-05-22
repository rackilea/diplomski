SVNRepository repository = SVNRepositoryFactory.create( SVNURL.parseURIDecoded( url ) );

   ISVNEditor editor = repository.getCommitEditor( logMessage , null /*locks*/ , true /*keepLocks*/ , null /*mediator*/ );

   //the second and the third parameters are the path and revision respectively 
   //of the item's ancestor if the item is being added with history
   editor.addFile( "your/path/project/README.txt" , null , -1 );