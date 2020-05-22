File foo = new File("foo");
foo.mkdir();
foo.deleteOnExit();
File bar = new File("foo/bar.txt");
bar.createNewFile();
bar.deleteOnExit();