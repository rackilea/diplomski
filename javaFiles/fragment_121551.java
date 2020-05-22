String filename = "C:\\generated.class"; 

// Generate class

System.out.println("Generating MyClass");
ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS|ClassWriter.COMPUTE_FRAMES);
cw.newClass("MyClass");
cw.newField("owner", "value", "I");

// Print generated class to STDIO to see that is generated as expected

System.out.println("Generated:");
ClassPrinter cp = new ClassPrinter();
cp.accept(cw, 0);

// Write the generated class to a file

System.out.println("Writing " + filename);
FileOutputStream os = new FileOutputStream(filename);
os.write(cw.toByteArray());
os.close();

// Read the file back

System.out.println("Reading " + filename);
ClassReader cr = new ClassReader(new FileInputStream("C:\\generated.class"));

// Print the class 

System.out.println("Read");
cr.accept(c, 0);
cr.accept(cw,0);