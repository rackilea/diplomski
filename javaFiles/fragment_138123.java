@RequestMapping("/search/**")  
public Map searchWithSearchTerm(HttpServletRequest request) { 
    // Don't repeat a pattern
    String pattern = (String)
        request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);  

    String searchTerm = new AntPathMatcher().extractPathWithinPattern(pattern, 
        request.getServletPath());

    ...
}