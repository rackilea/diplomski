class WriteNumbers implements IoOperation<Integer> {
    private Writer target;
    WriteNumbers(Writer writer) {
        target=writer;
    }
    public void accept(Integer i) throws IOException {
        try {
            final Writer writer = target;
            if(writer!=null) writer.append(i+"\n");
            //if(Math.random()>0.9) throw new IOException("test trigger");
        } catch (IOException ex) {
            if(target!=null) throw ex;
        }
    }
    @Override
    public void commit() throws IOException {
        target.append("done.\n").close();
    }
    @Override
    public void rollback() throws IOException {
        System.err.print("rollback");
        Writer writer = target;
        target=null;
        writer.close();
    }
}
FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
FileChannel fch = fos.getChannel();
Writer closableStdIO=new OutputStreamWriter(fos);
try {
    processAllAtems(IntStream.range(0, 100).parallel().boxed(),
                    new WriteNumbers(closableStdIO));
} finally {
    if(fch.isOpen()) throw new AssertionError();
}