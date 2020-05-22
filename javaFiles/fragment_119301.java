public class RecordAdapter extends TypeAdapter<Record> {

    @Override
    public Record read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
             reader.nextNull();
             return null;
        }
        Record record = new Record();
        // read array representing a record
        reader.beginArray();
        record.setCdmId(reader.nextString());
        record.setTransactionNumber(Integer.valueOf(reader.nextString()));
        record.setCollectorUserNumber(reader.nextString());
        record.setCollectionStartTime(reader.nextString());
        record.setSealNumber(reader.nextString());
        // read array containing CollectionType objects
        reader.beginArray();
        while(reader.hasNext()) {
            // read array containing single CollectionTyoe object
            reader.beginArray();
            CollectionType collectionType = new CollectionType();
            collectionType.setType(reader.nextString());
            collectionType.setCurrency(reader.nextString());
            collectionType.setTotalAmount(reader.nextDouble());
            collectionType.setTotalPcs(reader.nextInt());
            record.addCollectionType(collectionType);
            // read end of array containing single CollectionTyoe object
            reader.endArray();
        }
        // read end of array containing CollectionType
        reader.endArray();
        // read end of array representing a record
        reader.endArray();
        return record;
    }

    @Override
    public void write(JsonWriter arg0, Record arg1) throws IOException {
        // TODO Auto-generated method stub

    }

}