SeekableInput seekableInput = new AvroFSInput(dataInputStream, 5);    
DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>();
DataFileReader<GenericRecord> fileReader = new DataFileReader<GenericRecord>(seekableInput, datumReader);

**fileReader.sync(startOffset);**

while (fileReader.hasNext() && !fileReader.pastSync(endOffset)) {
    GenericRecord gr = fileReader.next();
    System.out.println(gr);
}