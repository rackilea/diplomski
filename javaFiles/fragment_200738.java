public static void main(String[] args) throws Exception {
  List<FileReader> threads = new ArrayList<FileReader>();

  threads.add(new FileReader(new File("foo1")));
  threads.add(new FileReader(new File("foo2")));
  threads.add(new FileReader(new File("foo3")));
  threads.add(new FileReader(new File("foo4")));

  for (FileReader t : threads) {
    t.start();
  }

  List<String> allLines = new ArrayList<String>();

  for (FileReader t : threads) {
    t.join();
    allLines.addAll(Arrays.asList(t.getLines()));
  }    

  // File lines now in allLines
}