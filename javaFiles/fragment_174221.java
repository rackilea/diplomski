if ( verbose )
{
    // verbose mode force Maven 2 dependency tree component use
    dependencyTreeString =
        serializeVerboseDependencyTree( dependencyTreeBuilder.buildDependencyTree( project,
                                                                                   localRepository,
                                                                                   artifactFilter ) );
}