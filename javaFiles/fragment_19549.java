ResteasyProviderFactory pf;
BasicHttpParams params;

pf = ResteasyProviderFactory.getInstance();

pf.addClientErrorInterceptor(new DataExceptionInterceptor());

params = new BasicHttpParams();
HttpProtocolParams.setVersion(params,
                              HttpVersion.HTTP_1_1);
HttpProtocolParams.setContentCharset(params,
                                     HTTP.DEFAULT_CONTENT_CHARSET);
HttpProtocolParams.setUseExpectContinue(params,
                                        false);
return ProxyFactory.create(AndroidEquipmentResourceIF.class,
                           ProxyFactory.createUri(requestURI),
                           new ThreadSafeApacheHttpClient4Executor(params),
                           pf);