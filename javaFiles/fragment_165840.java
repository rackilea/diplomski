public static WebArchive testWar() {
    File[] libs
            = Maven.resolver().loadPomFromFile( "pom.xml" )
            .resolve( "commons-io:commons-io" )
            .withTransitivity()
            .asFile();

    System.out.println( "libs = " + Arrays.toString( libs ) );

    return ShrinkWrap.create( WebArchive.class )
            .setWebXML( new File( "src/main/webapp/WEB-INF/web.xml" ) )
            .addAsWebInfResource( new File( "src/main/webapp/WEB-INF/jboss-web.xml" ) )
            .addAsWebInfResource( EmptyAsset.INSTANCE, "beans.xml" )
            .addPackages( false, Filters.exclude( ".*Test.*" ), getCorePackages() )
            .addAsLibraries( libs );
}