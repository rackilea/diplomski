File dir = new File(".");
if(!dir.isDirectory()) throw new IllegalStateException("wtf mate?");
for(File file : dir.listFiles()) {
    if(file.getName().startsWith("@"))
        process(file);
}