ERROR - 2017-09-23 01:29:47.912; org.apache.solr.core.CoreContainer; Error creating core [blog]: null
org.apache.solr.common.SolrException
    at org.apache.solr.core.SolrCore.<init>(SolrCore.java:881)
    at org.apache.solr.core.SolrCore.<init>(SolrCore.java:654)
    at org.apache.solr.core.CoreContainer.create(CoreContainer.java:491)
    at org.apache.solr.core.CoreContainer.create(CoreContainer.java:466)
    ...SNIP...
    at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:543)
    at java.lang.Thread.run(Thread.java:748)
Caused by: java.lang.NullPointerException
    at org.apache.solr.common.params.SolrParams.toSolrParams(SolrParams.java:296)
    at org.apache.solr.handler.RequestHandlerBase.init(RequestHandlerBase.java:111)
    at org.apache.solr.handler.PingRequestHandler.init(PingRequestHandler.java:139)
    at org.apache.solr.core.RequestHandlers.initHandlersFromConfig(RequestHandlers.java:184)
    at org.apache.solr.core.SolrCore.<init>(SolrCore.java:800)
    ... 35 more