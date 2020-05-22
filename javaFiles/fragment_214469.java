@Bean
public FilterChainProxy springSecurityFilterChain() throws Exception {
    // AuthenticationEntryPoint
    BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
    entryPoint.setRealmName("AppName Realm");
    // accessDecisionManager
    List<AccessDecisionVoter> voters = Arrays.<AccessDecisionVoter>asList(new RoleVoter(), new WebExpressionVoter());
    AccessDecisionManager accessDecisionManager = new AffirmativeBased(voters);
    // SecurityExpressionHandler
    SecurityExpressionHandler<FilterInvocation> securityExpressionHandler = new DefaultWebSecurityExpressionHandler();
    // AuthenticationUserDetailsService
    UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken> authenticationUserDetailsService = new UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken>(authUserDetailService);
    authenticationUserDetailsService.afterPropertiesSet();
    // PreAuthenticatedAuthenticationProvider
    PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider = new PreAuthenticatedAuthenticationProvider();
    preAuthenticatedAuthenticationProvider.setPreAuthenticatedUserDetailsService(authenticationUserDetailsService);
    preAuthenticatedAuthenticationProvider.afterPropertiesSet();
    // AuthenticationManager
    List<AuthenticationProvider> providers = Arrays.<AuthenticationProvider>asList(preAuthenticatedAuthenticationProvider);
    AuthenticationManager authenticationManager = new ProviderManager(providers);
    // HttpSessionSecurityContextRepository
    HttpSessionSecurityContextRepository httpSessionSecurityContextRepository = new HttpSessionSecurityContextRepository();
    // SessionRegistry
    SessionRegistry sessionRegistry = new SessionRegistryImpl();
    // ConcurrentSessionControlStrategy
    ConcurrentSessionControlStrategy concurrentSessionControlStrategy = new ConcurrentSessionControlStrategy(sessionRegistry);

    // ConcurrentSessionFilter
    ConcurrentSessionFilter concurrentSessionFilter = new ConcurrentSessionFilter(sessionRegistry);
    concurrentSessionFilter.afterPropertiesSet();
    // SecurityContextPersistenceFilter
    SecurityContextPersistenceFilter securityContextPersistenceFilter = new SecurityContextPersistenceFilter(httpSessionSecurityContextRepository);
    // X509AuthenticationFilter
    X509AuthenticationFilter x509AuthenticationFilter = new X509AuthenticationFilter();
    x509AuthenticationFilter.setAuthenticationManager(authenticationManager);
    x509AuthenticationFilter.afterPropertiesSet();
    // RequestCacheAwareFilter
    RequestCacheAwareFilter requestCacheAwareFilter = new RequestCacheAwareFilter();
    // SecurityContextHolderAwareRequestFilter
    SecurityContextHolderAwareRequestFilter securityContextHolderAwareRequestFilter = new SecurityContextHolderAwareRequestFilter();
    // SessionManagementFilter
    SessionManagementFilter sessionManagementFilter = new SessionManagementFilter(httpSessionSecurityContextRepository, concurrentSessionControlStrategy);
    // ExceptionTranslationFilter
    ExceptionTranslationFilter exceptionTranslationFilter = new ExceptionTranslationFilter(entryPoint);
    exceptionTranslationFilter.setAccessDeniedHandler(new AccessDeniedHandlerImpl());
    exceptionTranslationFilter.afterPropertiesSet();
    // FilterSecurityInterceptor
    FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
    filterSecurityInterceptor.setAuthenticationManager(authenticationManager);
    filterSecurityInterceptor.setAccessDecisionManager(accessDecisionManager);
    LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> map = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
    map.put(new AntPathRequestMatcher("/**"), Arrays.<ConfigAttribute>asList(new SecurityConfig("isAuthenticated()")));
    ExpressionBasedFilterInvocationSecurityMetadataSource ms = new ExpressionBasedFilterInvocationSecurityMetadataSource(map, securityExpressionHandler);
    filterSecurityInterceptor.setSecurityMetadataSource(ms);
    filterSecurityInterceptor.afterPropertiesSet();
    // SecurityFilterChain
    SecurityFilterChain chain = new DefaultSecurityFilterChain(new AntPathRequestMatcher("/**"),
            concurrentSessionFilter,
            securityContextPersistenceFilter,
            x509AuthenticationFilter,
            requestCacheAwareFilter,
            securityContextHolderAwareRequestFilter,
            sessionManagementFilter,
            exceptionTranslationFilter,
            filterSecurityInterceptor);
    return new FilterChainProxy(chain);
}