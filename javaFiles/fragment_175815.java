final String name = "abc.txt";

FileOutputStream fs = new FileOutputStream(name);
fs.write(143);
fs.close();

System.out.println("finished, file.length=" + new File(name).length());