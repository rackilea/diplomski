HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpServletResponse httpRes = (HttpServletResponse) response;
    String randomLong = ""+random.nextLong();
    Cookie cookie = new Cookie("csrfToken", randomLong);        
    httpRes.addCookie(cookie);
    next.doFilter(request, response);