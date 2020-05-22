public class MyEntryProcessor implements EntryProcessor<String, MapValue>, EntryBackupProcessor<String, MapValue>, Offloadable, Portable {

private static final long   serialVersionUID = 1L;


private MapValue mapValue;


public MyEntryProcessor() {

}

public MyEntryProcessor(MapValue mapValue) {
    this.mapValue = mapValue;
}

@Override
public Object process(Entry<String, MapValue> entry) {

    MapValue valueToSet = null;
    if (null == entry.getValue()) {
        valueToSet = mapValue;
    } else {
        MapValue valueToUpdate = entry.getValue();
        valueToUpdate.setData(mapValue.getData());
        valueToSet = valueToUpdate;
    }

    entry.setValue(valueToSet);

    return null;
}

@Override
public String getExecutorName() {
    //return NO_OFFLOADING;
    return OFFLOADABLE_EXECUTOR;
}

@Override
public int getClassId() {
    return 2;
}

@Override
public int getFactoryId() {
    return 1;
}

@Override
public void readPortable(PortableReader reader) throws IOException {
    if (reader.readBoolean("_has__mapValue")) {
        ObjectDataInput in = reader.getRawDataInput();
        mapValue = in.readObject();
    }
}

@Override
public void writePortable(PortableWriter writer) throws IOException {
    boolean hasMapValue = (mapValue != null);
    writer.writeBoolean("_has__mapValue", hasMapValue);
    if (hasMapValue) {
        ObjectDataOutput out = writer.getRawDataOutput();
        out.writeObject(mapValue);
    }

}

@Override
public EntryBackupProcessor<String, MapValue> getBackupProcessor() {
    return this;
}

@Override
public void processBackup(Entry<String, MapValue> entry) {
    process(entry);
}
}