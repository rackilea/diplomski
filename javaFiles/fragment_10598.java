@Override
protected RouteBuilder createRouteBuilder() {
    return new SampleRoute(<param>);
}

@Override
protected JndiContext createJndiContext() throws Exception {
    JndiContext context = new JndiContext();
    context.bind("barProcessor", new BarProcessor());
    context.bind("bieProcessor", new BieProcessor());
    return context;
}