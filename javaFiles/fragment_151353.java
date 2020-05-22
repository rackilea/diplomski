File parent = new File("/home/logs/");
if(!parent.exists())
    parent.mkdir();

File file = new File(parent, "MyLogFile.log");
// TODO: do something with file...