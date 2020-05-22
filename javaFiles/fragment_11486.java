protected MockWebServiceServer build() {
    MockWebServiceServer server =  MockWebServiceServer.createServer(gatewaySupport);

    for(MockAction action: mockActions) {
        action.performAction(server);
    }
    return server;
}