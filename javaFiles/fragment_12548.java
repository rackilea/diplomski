public static void main(Configuration conf,
                       String[] args) throws IOException, ParseException {
 CommandLine opts = parseOptions(args);
 TypeDescription schema;
 if (opts.hasOption('s')) {
   schema = TypeDescription.fromString(opts.getOptionValue('s'));
 } else {
   schema = computeSchema(opts.getArgs());
 }
 String outFilename = opts.hasOption('o')
     ? opts.getOptionValue('o') : "output.orc";
 Writer writer = OrcFile.createWriter(new Path(outFilename),
     OrcFile.writerOptions(conf).setSchema(schema));
 VectorizedRowBatch batch = schema.createRowBatch();
 for (String file: opts.getArgs()) {
   System.err.println("Processing " + file);
   RecordReader reader = new JsonReader(new Path(file), schema, conf);
   while (reader.nextBatch(batch)) {
     writer.addRowBatch(batch);
   }
   reader.close();
 }
 writer.close();
}