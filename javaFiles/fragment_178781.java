private CommandBus configureDistributedCommandBus() throws Exception {

    CommandBus commandBus = new SimpleCommandBus();

    channel = new JChannel(getClass().getClassLoader().getResourceAsStream("tcp.xml"));

    RoutingStrategy rs = new AbstractRoutingStrategy(UnresolvedRoutingKeyPolicy.STATIC_KEY) {

        @Override
        protected String doResolveRoutingKey(CommandMessage<?> cmdMsg) {

            View view = channel.getView();

            if (view.getMembers().size() == 2) {

                return "secondary";

            } else if (view.getMembers().size() == 1) {

            }

            return cmdMsg.getIdentifier();
        }
    };

    connector = new JGroupsConnector(commandBus, channel, "axon-jgroups-demo", new XStreamSerializer(), rs);
    connector.updateMembership(100, AcceptAll.INSTANCE);

    connector.connect();
    connector.awaitJoined();

    return new DistributedCommandBus(connector, connector);
}