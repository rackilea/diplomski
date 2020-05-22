@Override public void configure(WebSecurity web) throws Exception {
    web.ignoring()
       .requestMatchers(ignoreNonJsonMediaTypes())
       .and()
       .ignoring()
       .antMatchers(HttpMethod.POST);

    super.configure(web);
}

private MediaTypeRequestMatcher ignoreNonJsonMediaTypes() {
    MediaTypeRequestMatcher
        matcher =
        new MediaTypeRequestMatcher(new HeaderContentNegotiationStrategy(), MediaType.APPLICATION_JSON);
    matcher.setIgnoredMediaTypes(Collections.singleton(MediaType.ALL));
    return matcher;
}