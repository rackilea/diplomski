protected void addProcessor(String name, Object svc) {
    ThriftCodecManager codecManager = new ThriftCodecManager(
        new CompilerThriftCodecFactory(false)
    );
    List<ThriftEventHandler> eventList = Collections.emptyList();
    ThriftServiceProcessor proc = new ThriftServiceProcessor(codecManager, eventList, svc);
    this.processors.put(name, proc);
    this.multiplex.registerProcessor(name, NiftyProcessorAdapters.processorToTProcessor(proc));
}