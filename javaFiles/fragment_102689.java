String str = null;
String topItem = null;
StringStackImpl<String> stack = new StringStackImpl<>(); 
BufferedReader br = new BufferedReader(new FileReader(path));
while((str = br.readLine()) != null) {
    String[] line = str.split("\\s") ;
    for(String word : line) {
        if(word.contains("<")&&!word.contains("</")){
            stack.push(word);
        }
        if(word.startsWith("</")&& !stack.empty()) {
            topItem = stack.peek().replaceAll("[^a-zA-Z ]", "");
            if(topItem.equals(word.replaceAll("[^a-zA-Z ]", ""))){
                stack.pop();
            }
        }
} 
stack.printStack(System.out);