public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if(httpRequest.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) {
            chain.doFilter(request, response);
        } else {
            if (!(((HttpServletRequest)request).getRequestURI().endsWith("/auth/login")
                    || ((HttpServletRequest)request).getRequestURI().endsWith("/auth/signup"))){

                String authHeader = httpRequest.getHeader(AuthUtils.AUTH_HEADER_KEY);
                Enumeration<String> prueba = httpRequest.getHeaderNames();
                while ( prueba.hasMoreElements()) {
                    String headerName = prueba.nextElement();
                    logger.info("Header "+ headerName);
                    logger.info("getHeader "+httpRequest.getHeader(headerName));
                }
                logger.info("AuthHeader "+ authHeader);
                if (StringUtils.isEmpty(authHeader) || authHeader.split(" ").length != 1) {
                    logger.error("No tiene token");
                    httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, AUTH_ERROR_MSG);
                } else {
                    JWTClaimsSet claimSet = null;
                    try {
                        claimSet = (JWTClaimsSet) AuthUtils.decodeToken(authHeader);
                    } catch (ParseException e) {
                        httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, JWT_ERROR_MSG);
                        return;
                    } catch (JOSEException e) {
                        httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, JWT_INVALID_MSG);
                        return;
                    }
                    // ensure that the token is not expired
                    if (new DateTime(claimSet.getExpirationTime()).isBefore(DateTime.now())) {
                        httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, EXPIRE_ERROR_MSG);
                    } else {
                        chain.doFilter(request, response);
                    }
                }
            }else{
                chain.doFilter(request, response);
            }
        }

    }