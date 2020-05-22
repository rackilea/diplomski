ProcessBuilder pb = new ProcessBuilder("java", "HelloWorld");
pb.directory(new File("src"));
pb.redirectError();
Process p = pb.start();

InputStreamConsumer.consume(p.getInputStream());

p.waitFor();