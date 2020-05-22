@Ready
public String onReady(final AtmosphereResource resource) {
    String AuthHeader = resource.getRequest().getHeader("Authorization");

    ...DO AUTH HERE

    logger.info("Resource {} connected ", resource.uuid());
    return "Connect " + resource.uuid();
}