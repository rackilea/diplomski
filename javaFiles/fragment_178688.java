int fileCount = 1273;
String diskName = "MyDisk";
Object[] testArgs = {new Long(fileCount), diskName};

MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0} file(s).");

System.out.println(form.format(testArgs));