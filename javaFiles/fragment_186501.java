private void exposeEffectiveLookupPathKey(HandlerMethod method, HttpServletRequest request, String repositoryBasePath) {

    RequestMappingInfo mappingInfo = getMappingForMethod(method.getMethod(), method.getBeanType());

    if (mappingInfo == null) {
        return;
    }

    ...
}