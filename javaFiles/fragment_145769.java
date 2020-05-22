static void main(String args[]) throws IOException {

  FileInputStream fin=new FileInputStream("sample.txt");

  try {

    BufferedReader br=new BufferedReader(new InputStreamReader(fin));

    String line = Read_one_Line(br);
    while ( line != null ) {
      System.out.println(line);
      line = Read_one_Line(br);
    }

  } finally {
    fin.close(); // Make sure we close the file when we're done.
  }
}