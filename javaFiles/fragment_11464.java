@Test
public void doFilterTest() throws IOException, ServletException {
    final String CACHE_CONTROL_VALUE = "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0";
    response.setHeader("Cache-Control", "some value");

    cacheControlFilter.doFilter(request, response, filterChain);

    assertEquals(response.getHeader("Cache-Control"), CACHE_CONTROL_VALUE);
}