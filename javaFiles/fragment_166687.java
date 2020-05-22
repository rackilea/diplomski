@GetMapping(value = "/rest/**",...
public Rsp test(HttpServletReq req) {
private String getSqlTemplateKey(HttpServletRequest req) {
    String pattern = (String) req.getAttribute(BEST_MATCHING_PATTERN_ATTRIBUTE);
    String urlpart = PATH_MATCHER.extractPathWithinPattern(pattern, req.getServletPath());
}