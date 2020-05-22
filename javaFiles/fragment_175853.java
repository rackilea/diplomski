public void readFile(BufferedReader br) {
  boolean inDefinition = false;
  while(br.ready()) {
    String next = br.readLine().trim();
    if(next.isEmpty()) {
      inDefinition = false;
      continue;
    }
    if(!inDefinition) {
      handleWord(next);
      inDefinition = true;
    } else {
      handleDefinition(next);
    }
  }
}