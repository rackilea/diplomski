String input_text;     
input_text = JOptionPane.showInputDialog("Write in some text");
System.out.println("Index of e in input_text: "+ getMatchCount(input_text, 'e'));

int getMatchCount(String input, char charToMatch) {
    int count = 0;
    for(int i = 0; i < input.length(); i++) {
        if(input.charAt(i) == charToMatch) {
            count++;
        }
    }
    return count;
}