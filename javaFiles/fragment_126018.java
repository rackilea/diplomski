ivy {
    url "//ourserver/Repository/ivy-thirdparty"
    layout "pattern", {
        ivy "[organisation]/[module]/[revision]/[module]-[revision].xml"
        artifact "[organisation]/[module]/[revision]/[artifact]-[revision](-[classifier]).[ext]"
    }
}