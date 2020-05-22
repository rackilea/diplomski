public class MyRedisBolt extends AbstractRedisBolt {
    private TopologyContext context = null;

    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        super.prepare(map, topologyContext, collector);
        this.context = topologContext;
    }
}