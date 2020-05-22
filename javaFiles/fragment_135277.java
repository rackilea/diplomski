ProcessBuilder pb =
  new ProcessBuilder("myCommand", "myArg1", "myArg2");
pb.redirectErrorStream(true); // merges err with out
pb.redirectOutput(Redirect.appendTo(new File("out.txt")));
Process p = pb.start();
p.waitFor();