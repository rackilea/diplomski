List<String> whiteListedParameters = Arrays.asList("a", "b");

@RequestMapping(value = "google.com", method = RequestMethod.GET)
public ModelAndView render(HttpServletRequest request) throws Exception {
    Enumeration<String> parameterNames = request.getParameterNames();
    while(parameterNames.hasMoreElements()) {
        String parameterName = parameterNames.nextElement();
        if(!whiteListedParameters.contains(parameterName)) {
            throw new Exception("Whatever you want");
        }
    }
    ...
}