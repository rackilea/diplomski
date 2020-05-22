Scanner input = new Scanner (file)
String word = "";
object myObject = new object(word);
while (input.hasNext()){
  word = input.next()
  myObject.setWord(word);
}