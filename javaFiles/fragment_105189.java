url = url.replace("https://", "");
url = url.replace("http://", "");
File outputfile = new File(url);
String parentPath = outputfile.getParent();
String name = outputfile.getName();

url = parentPath + File.separator + name;