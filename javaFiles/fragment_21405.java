Scanner inputStream = new Scanner(new File("location/of/your/file.txt"));
List<String> words = new ArrayList<>();
while (inputStream.hasNext()){
    words.add(inputStream.next());
}
inputStream.close();

for (String word : words){
     //here you can do whatever you want with each word from list
     System.out.println(word);
}