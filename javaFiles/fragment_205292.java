@Test
public void testDoFilter() throws Exception {
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    FilterChain filterChain = mock(FilterChain.class);

    Handler handler = new Handler();
    handler.doFilter(request, response, filterChain);

    verify(request).getSession(false);
    // other assertions
}