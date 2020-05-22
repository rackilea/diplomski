if (kind == 2) {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Please insert a morse string");
  try {
    MoToEng(br.readLine());
  } catch (IOException e) {
    e.printStackTrace();
  }
}