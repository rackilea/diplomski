public class CustomHeadersPageCachingFilter extends SimpleCachingHeadersPageCachingFilter {

    @Override
    protected PageInfo buildPage(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws AlreadyGzippedException, Exception {
        PageInfo pageInfo = super.buildPage(request, response, chain);
        headers.add(new Header<String>("X-Content-Type-Options", "nosniff"));
        headers.add(new Header<String>("X-XSS-Protection", "1; mode=block"));
        return pageInfo;
    }
}