Extension01.Message.Builder bm = Extension01.Message.newBuilder();
Extension01.Message.Builder bm1 = Extension01.Message.newBuilder();
Extension01.Event.Builder be = Extension01.Event.newBuilder();
FileOutputStream out = new FileOutputStream(extFileOut);

be.setB(5678);


bm.setA(123);
bm.setExtension(Extension01.Event.ext, be.build()); // set the extension value

bm.build().writeDelimitedTo(out);
out.close();

FileInputStream in = new FileInputStream(extFileOut);

ExtensionRegistry registry = ExtensionRegistry.newInstance(); // create extension registry
Extension01.registerAllExtensions(registry);  // Allocate the extensions 
bm1.mergeDelimitedFrom(in, registry);
in.close();

Event extension = bm1.getExtension(Extension01.Event.ext); // get the extension
if (extension == null) {
    System.out.println("No extension");
} else {
    System.out.println(extension.getB());
}