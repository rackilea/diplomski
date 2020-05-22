repository {
    jcenter()
    jcenter{
        url 'http://oss.jfrog.org/artifactory/oss-snapshot-local'
    }
}

dependency {
    // Include the sdk as a dependency
    compile('com.microsoft.graph:microsoft-graph-auth:0.1.0-SNAPSHOT')
}