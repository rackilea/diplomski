ProcessBuilder processBuilder = new ProcessBuilder("ls", "-l").directory(new File(file.getParent()));// TODO CHECK IF THE FILE IS SD CARD PARENT IS NULL
  if(BuildConfig.DEBUG)Log.v(TAG, "dir:-"+processBuilder.directory());
  Process process = processBuilder.start();
  PrintWriter out = new PrintWriter(new OutputStreamWriter(process.getOutputStream()));
  BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
  out.flush();
  String resultLine;
  resultLine = in.readLine();

  while (resultLine != null) {
      System.out.println(resultLine);
}