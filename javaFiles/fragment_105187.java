path = path.replace("http://", "");
path = path.replace("https://", "");

File outputfile = new File(path);
File parent = outputfile.getParentFile();
parent.mkdir();