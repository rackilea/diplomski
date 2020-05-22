File file = new File("foo.txt");
BufferedReader br = new BufferedReader (new FileReader(file));
String line;

while((line = br.readLine()) != null){
 doSomething(line);
}

//EDIT: if you want to get all your lines to one String that seperates the lines with \n replace doSomething(line) with
String str = "";
while((line = br.readLine()) != null){
 str+=line.concat("\n");
}