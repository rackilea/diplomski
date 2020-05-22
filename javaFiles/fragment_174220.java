if ( verbose )
{
    // verbose mode force Maven 2 dependency tree component use
    if ( ! isMaven2x() )
    {
        getLog().warn( "Using Maven 2 dependency tree to get verbose output, "
                           + "which may be inconsistent with actual Maven 3 resolution" );
    }
    dependencyTreeString =
        serializeVerboseDependencyTree( dependencyTreeBuilder.buildDependencyTree( project,
                                                                                   localRepository,
                                                                                   artifactFilter ) );
}