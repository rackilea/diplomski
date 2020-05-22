ivy {
    url "http://red5.googlecode.com/svn/repository"
    layout "pattern", {
        artifact "[artifact](-[revision]).[ext]"
        artifact "[organisation]/[artifact](-[revision]).[ext]"
    }
}