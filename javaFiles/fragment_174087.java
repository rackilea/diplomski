Path path = new Path("/path/on/hdfs");
Configuration config = new Configuration(); // make this your Hadoop env config
SeekableInput input = new FsInput(path, config);
DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>();
FileReader<GenericRecord> fileReader = DataFileReader.openReader(input, reader);

for (GenericRecord datum : fileReader) {
    System.out.println("value = " + datum);
}

fileReader.close(); // also closes underlying FsInput