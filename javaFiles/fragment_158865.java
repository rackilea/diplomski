Charset charset = Charset.forName("UTF-8");
List<String> list = new ArrayList<String>();
try(
  FileInputStream is1=new FileInputStream("sum1.csv");
  FileInputStream is2=new FileInputStream("sum2.csv");
  SequenceInputStream is=new SequenceInputStream(is1, is2);
  BufferedReader reader=new BufferedReader(new InputStreamReader(is, charset));)
{
  try {
      String line;
      while((line = reader.readLine()) != null && !line.isEmpty()){
          list.add(line);
      }
  } catch (IOException e) {
      System.err.format("IOException: %s%n", e);
  }
}