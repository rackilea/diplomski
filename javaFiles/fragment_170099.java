Page page = "pagePath";  
ResourceResolver resourceResolver = getResourceResolver();
Resource parent = resourceResolver.resolve(pagePath + "/target");
PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

if (parent.getResourceType().equals(Resource.RESOURCE_TYPE_NON_EXISTING) {
    pageManager.create(pagePath, "target", "SOME_TEMPLATE_NAME", "SOME_TITLE");
}

pageManager.copy(pagePath, pagePath + "/target/newPage", null, true, false);