try {
  List<String> res = Files.readAllLines(Paths.get(myObject),
          StandardCharsets.UTF_8);
  StringBuilder anotherTest = new StringBuilder();
  for(String str : res) {
      anotherTest.append(str);
  }
  serializedString = anotherTest.toString();
} catch (IOException e) {
  e.printStackTrace();
}