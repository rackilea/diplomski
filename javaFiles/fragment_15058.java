@Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<OrderedDeviceByOrderId> findOrderedDeviceByOrderId(String clientid) {
        AggregationOperation lookup = Aggregation.lookup("ordereddevice","_id","order","Devices");
        AggregationOperation match = Aggregation.match(Criteria.where("clientId").is(clientid));
        Aggregation agg = Aggregation.newAggregation(match, lookup);

        AggregationResults<OrderedDeviceByOrderId> results = mongoTemplate.aggregate(agg, "order", OrderedDeviceByOrderId.class);
        List<OrderedDeviceByOrderId> orderedDeviceByOrderId = results.getMappedResults();

        orderedDeviceByOrderId.forEach(s -> System.out.println(s));
        return orderedDeviceByOrderId;
    }