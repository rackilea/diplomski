isResourceUnderLocation(Resource resource, Resource location) {
    ...
    resourcePath = ((ServletContextResource) resource).getPath();
    locationPath = StringUtils.cleanPath(((ServletContextResource) location).getPath());
    ...
    if (!resourcePath.startsWith(locationPath)) {
        return false;
    }
    ...
 }