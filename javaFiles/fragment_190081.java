public static String getArticleIncludePath(Page givenPage, String pageName, ResourceResolver resourceResolver) throws Exception {
    // Call createChildPage to build out child page as needed
    createChildPage(givenPage, resourceResolver, pageName);
    // Now get the child includePath
    String childPath = givenPage.getPath() + pageName;
    return childPath;
}