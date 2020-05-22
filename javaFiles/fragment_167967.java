Path source = Paths.get("D:\\A\\B\\C\\D\\E\\F\\G\\a.mp4"); // original file's absolute path
Path link = Paths.get("D:\\A\\B\\C\\D\\E\\F\\H\\I\\a.mp4"); // symbolic link's absolute path
Path relativeSrc = link.getParent().relativize(source); // relative path of original file from symbolic link

link.getParent().toFile().mkdirs(); // create the directory hierarchy if any folder is not available 
Files.createSymbolicLink(link, reativeSrc); // create symbolic link.