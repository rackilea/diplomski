Properties properties = new Properties();
AppProps.setApplicationJarClass(properties, TestCascading.class);
FlowConnector flowConnector = new LocalFlowConnector();
// create the source tap
FileTap inTap = new FileTap(new TextLine(), "C://Users//rain.txt");
// create the sink tap
FileTap outTap = new FileTap(new TextLine(), "C://Users//out.txt");
// specify a pipe to connect the taps
Pipe copyPipe = new Pipe("copy");
// connect the taps, pipes, etc., into a flow
FlowDef flowDef = FlowDef.flowDef().addSource(copyPipe, inTap).addTailSink(copyPipe, outTap);

// run the flow
Flow flow = flowConnector.connect(flowDef);
flow.complete();