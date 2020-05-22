RecordStore recordStore = RecordStore.openRecordStore("My recordStore", false);
    RecordEnumeration records = recordStore.enumerateRecords(null, null, true);
    while (records.hasNextElement()) {
       byte[] recordData = records.nextRecord();

       ByteArrayInputStream bais = new ByteArrayInputStream(recordData);
       DataInputStream dis = new DataInputStream(bais);

       short arrayLength = dis.readShort();
       byte[] bytes = new byte[arrayLength];
       dis.read(bytes, 0, arrayLength);