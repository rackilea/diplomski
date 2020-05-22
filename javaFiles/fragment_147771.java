public static int convertAvro(String avroFile) throws Exception {

    PrintStream out = new PrintStream(System.out);
    GenericDatumReader<Object> reader=new GenericDatumReader<Object>();
    org.apache.avro.file.FileReader<Object>  fileReader=  DataFileReader.openReader(new File(avroFile),reader);
      try {
        Schema schema=fileReader.getSchema();
        // System.out.print(schema);
        DatumWriter<Object> writer=new GenericDatumWriter<Object>(schema);
        JsonEncoder encoder=EncoderFactory.get().jsonEncoder(schema,out);
        for (Object datum : fileReader)     writer.write(datum,encoder);
        encoder.flush();
        out.println();
        out.flush();
      }
      finally {
        fileReader.close();
      }
      return 0;
}