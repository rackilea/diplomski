StreamFactory factory = StreamFactory.newInstance();
StreamBuilder builder = new StreamBuilder("") // Your file
    .format("delimited")
    .parser(new DelimitedParserBuilder(',')) // Sign to  use as a delimiter
    .addRecord(Yourclass.class); // class to be mapped 

factory.define(builder);