url = new URL(getBaseURL(), ParseUtil.encodePath(name, false));
...
file = new File(dir, name.replace('/', File.separatorChar)); // dir is the equivalent of getBaseURL()'s path component
...
if (file.exists()) {
    return new sun.misc.Resource() {
        ...
        public URL getURL() { return url; } // eventually returned by the ClassLoader
    }
}