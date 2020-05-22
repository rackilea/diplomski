public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

protected HandlerMethod handleNoMatch(
        Set<RequestMappingInfo> requestMappingInfos, String lookupPath,
        HttpServletRequest request) throws ServletException {
    Set<String> allowedMethods = new HashSet<String>(6);
    Set<MediaType> consumableMediaTypes = new HashSet<MediaType>();
    Set<MediaType> producibleMediaTypes = new HashSet<MediaType>();
    for (RequestMappingInfo info : requestMappingInfos) {
        if (info.getPatternsCondition().getMatchingCondition(request) != null) {
            if (info.getMethodsCondition().getMatchingCondition(request) == null) {
                for (RequestMethod method : info.getMethodsCondition()
                        .getMethods()) {
                    allowedMethods.add(method.name());
                }
            }
            if (info.getConsumesCondition().getMatchingCondition(request) == null) {
                consumableMediaTypes.addAll(info.getConsumesCondition()
                        .getConsumableMediaTypes());
            }
            if (info.getProducesCondition().getMatchingCondition(request) == null) {
                producibleMediaTypes.addAll(info.getProducesCondition()
                        .getProducibleMediaTypes());
            }
        }
    }
    if (!producibleMediaTypes.isEmpty()) {
        throw new HttpMediaTypeNotAcceptableException(
                new ArrayList<MediaType>(producibleMediaTypes));
    } else if (!consumableMediaTypes.isEmpty()) {
        MediaType contentType = null;
        if (StringUtils.hasLength(request.getContentType())) {
            contentType = MediaType
                    .parseMediaType(request.getContentType());
        }
        throw new HttpMediaTypeNotSupportedException(contentType,
                new ArrayList<MediaType>(consumableMediaTypes));
    } else if (!allowedMethods.isEmpty()) {
        throw new HttpRequestMethodNotSupportedException(
                request.getMethod(), allowedMethods);
    } else {
        return null;
    }
}