BufferedWriter writer = new BufferedWriter(new FileWriter(new File("test.txt")));

String stuffToWrite = "Hello";

writer.write(stuffToWrite);

writer.close();