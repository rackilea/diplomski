private String getCurrentClasspath(boolean trim) {
    StringBuilder builder = new StringBuilder();
    for (URL url : ((URLClassLoader) Thread.currentThread().getContextClassLoader()).getURLs()) {
        builder.append(new File(url.getPath()));
        builder.append(System.getProperty("path.separator"));
    }
    String classpath = builder.toString();
    return trim ? classpath.substring(0, classpath.length() - 1) : classpath;
}