for (Resource childResource: resource.getChildResources()) {
    if (childResource.getResourceLocator() != null) {
        ResourceMethod method = childResource.getResourceLocator();
        Class locatorType = method.getInvocable().getRawResponseType();
    }
}