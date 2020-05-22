public URL getResource(String name) {
    URL url = findResource(name); // this will load from your class loader
    if (url == null) {
        if (parent != null) {
            url = parent.getResource(name);
        } else {
            url = getBootstrapResource(name);
        }
    }

    return url;
}