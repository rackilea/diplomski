public class RSRVRecordWriter<KK,VV> extends RecordWriter<KK, VV> {

    @Override
    public void write(KK key, VV value) throws IOException {
        //Now here we can have an instance of aerospikeclient from a singleton class and then we could do client.put()

    }