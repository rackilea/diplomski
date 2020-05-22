@Bean public ThymeleafViewResolver thymeleafViewResolver()
{
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine( templateEngine() );
    return viewResolver;
}

@Bean public SpringTemplateEngine templateEngine()
{
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    Set<ITemplateResolver> templateResolvers = new HashSet();
    templateResolvers.add( thymeleafTemplateResolver() );
    templateResolvers.add( urlTemplateResolver() );
    templateEngine.setTemplateResolvers( templateResolvers );

    return templateEngine;
}

@Bean public SpringResourceTemplateResolver thymeleafTemplateResolver()
{
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setPrefix( "/WEB-INF/static/" );
    templateResolver.setSuffix( ".html" );
    templateResolver.setTemplateMode( "HTML5" );
    templateResolver.setOrder( 2 );
    return templateResolver;
}

@Bean public UrlTemplateResolver urlTemplateResolver()
{
    UrlTemplateResolver urlTemplateResolver = new UrlTemplateResolver();
    urlTemplateResolver.setCharacterEncoding( "UTF-8" );
    urlTemplateResolver.setTemplateMode( "HTML5" );
    urlTemplateResolver.setCacheable( false );
    urlTemplateResolver.setOrder( 3 );
    return urlTemplateResolver;
}