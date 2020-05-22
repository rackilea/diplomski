File tempfldr = new File("C:\\rootFolder\\childFolder1");
tempfldr.mkdirs();
File tempfldr2 = new File("C:\\rootFolder\\childFolder2");
tempfldr2.mkdirs();
File child1 = File.createTempFile("prefix_val", "suffix_val", tempfldr);
File child2 = File.createTempFile("prefix_val", "suffix_val", tempfldr2);