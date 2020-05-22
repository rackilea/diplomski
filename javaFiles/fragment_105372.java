ClassReader reader = new ClassReader("Target");
ClassWriter writer = new ClassWriter(reader, 0);
TraceClassVisitor printer = new TraceClassVisitor(writer, 
        new PrintWriter(System.getProperty("java.io.tmpdir") + File.separator + "Target.log"));
ClassAdapter adapter = new ClassAdapter(printer);
reader.accept(adapter, 0);
byte[] b = writer.toByteArray(); // The modified bytecode