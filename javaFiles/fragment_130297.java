int pageIndex = 0;
for (PDPage page : documentSrc.getPages()) {
    PDPage destPage = documentDest.getPage(pageIndex);
    destPage.setAnnotations(page.getAnnotations());
    for (PDAnnotation annotation : destPage.getAnnotations())
        annotation.setPage(destPage);
    // after disabling this size increase
    //documentDest.getPage(pageIndex).setResources(page.getResources());
    pageIndex++;
}