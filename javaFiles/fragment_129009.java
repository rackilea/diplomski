@Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {

        String token = req.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.replace("Bearer ", "");
            Authentication authentication = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(final String token) {

        try {
            DecodedJWT decodedToken = JWT.require(Algorithm.HMAC512(jwtSecret)).build().verify(token);
            String username = decodedToken.getSubject();
            return new UsernamePasswordAuthenticationToken(username , null, new ArrayList<>());
        } catch (JWTVerificationException ex) {
            log.error(ex.getMessage());
        }

        return null;
    }