@RequestMapping(value = "/projects/{projectId}/resources/web/**", method = RequestMethod.GET)
@ResponseBody
public void getWebFileContent(@PathVariable("projectId") String projectIdHttpServletRequest httpServletRequest) throws Exception {
    String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE); 
    // will get path = /projects/pro1/resources/web/src/main/webapp
    String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
    // will get bestMatchPattern = /projects/pro1/resources/web/**
    AntPathMatcher apm = new AntPathMatcher();
    String exactPath = apm.extractPathWithinPattern(bestMatchPattern, path);
    // will get exactPath = src/main/webapp
    .....
}