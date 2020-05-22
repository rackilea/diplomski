RepositoryClient(JasperserverRestClient httpRestClient, JasperServerInfo serverInfo) {
    this.info = serverInfo;
    this.httpRestClient = httpRestClient;

    try {
        restClientSession = httpRestClient.authenticate(info.username.trim(), info.password.trim());
    }
    catch (Exception e) {
        INodeProcessor.logger.warn(e.toString());
        throw Error.REPOSITORY_CLIENT_ERROR.with();
    }
}