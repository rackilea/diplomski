repositories {
    ivy {
        url "http://artifacthub.oraclecorp.com/epmpbcs-release-local"
        patternLayout {
            artifact "[module]/[revision]/[artifact].[ext]"
        }
    }
}