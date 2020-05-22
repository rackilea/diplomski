File file = new File("test.txt");
file.deleteOnExit();
Assert.assertTrue(!file.exists());
file.createNewFile();
throw new Exception("Foo");
file.delete();