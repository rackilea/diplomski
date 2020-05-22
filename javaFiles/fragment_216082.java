try (BufferedWriter wr = new BufferedWriter(new FileWriter(out));) {
  Pomini(a, b, wr);
}

public static void Pomini(String in, String out, BufferedWriter wr) throws IOException {
    File file = new File(in);
    if(file.exists()) {
        File[] subfiles = file.listFiles();
        for(File f : subfiles) {
            if(f.isDirectory()) {
                Pomini(f.getAbsolutePath(), out, wr);
            }
        if(f.getName().contains(".txt")) {
            System.out.print(f.getName());
            System.out.println();
            wr.write(f.getName());
            wr.newLine();
        }
     }

  }           

}