public static void main(String[] args) throws IOException {

      List<File> dirs = new LinkedList<File>();
      Files.find(Paths.get("."),
             Integer.MAX_VALUE,
            (path, basicFileAttributes) -> 
      dirs.add(path.toFile())).forEach((ignore)->{});

     java.lang.System.out.println( dirs.size() );
}