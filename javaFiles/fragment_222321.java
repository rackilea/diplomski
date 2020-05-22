BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String S = br.readLine();
List<String> splitted = new ArrayList<>(Arrays.asList(S.split("[ :#$%^&/<>{}*|;_()!,?.'@+\\\\\\[\\]\\\"]+")));
splitted.removeAll(Arrays.asList(null,""));
System.out.println(splitted.size());
for (String word: splitted) System.out.println(word);