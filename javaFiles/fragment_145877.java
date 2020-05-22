@Override
public final void doFilterInternal(
    HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
    ...
    if (pattern.matcher(request.getRequestURI()).matches()) {
        //process query
    }   
}