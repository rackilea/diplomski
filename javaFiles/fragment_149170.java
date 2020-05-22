public class MongoInsertBolt extends IBasicBolt {
    private static final long serialVersionUID = 2504213456001787553L;
    protected MongoCollection<Document> iotSampleColl;

    @Override
    public void prepare(Map stormConf, TopologyContext context) {
        MongoClient mongoClient = new MongoClient( "zz.yyy.xx.abc",27017 );
        mongoClient.setWriteConcern(WriteConcern.SAFE);
        MongoDatabase db = mongoClient.getDatabase("IOT");
        iotSampleColl = db.getCollection("iot_sample");
    }

    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        String word=tuple.getString(0);
        Document packet = new Document();
        packet.put("IOT_trans",word);
        if((null == word) || (word.length() == 0))
        {
            return;
        }
        iotSampleColl.insertOne(packet);
        System.out.println("Word is..."+word);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        // TODO Auto-generated method stub
    }
}