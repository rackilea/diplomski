Project p = new Project();
p.init();
p.addBuildListener( new SimpleBuildListener() );
p.setBaseDir( new File( "." ).getAbsoluteFile() );

Javac task = (Javac) p.createTask( "javac" );
task.srcdir( srcDirPath );

// Filsets can be built this way
FileSet set = new FileSet();
set.setDir( srcDirPath );
set.setIncludes( "**/*.java" );

task.addFileset( set );