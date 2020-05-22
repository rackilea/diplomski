String csrfToken = httpReq.getParameter("csrfToken");
        String tokenFromCookie = getCsrfTokenFromCookie(httpReq);
        if (WmUtil.isEmpty(csrfToken) || !csrfToken.equals(tokenFromCookie)) {
            httpRes.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }           
        else {
            next.doFilter(request, response);
        }