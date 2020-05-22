private String[] buffer;

private void draw(){ //please rename 'draw' to 'print' this is confusiong else
    for (String line: buffer){
        System.out.println(line);
    }
}

public void create(int topWidth, int bottomWidth, char foreground, char background, int margin){
    //as done in your code
}

public void rotate(){
    String[] newBuffer = new String[buffer.length()];
    for(int i = 0; i < buffer.length(); i ++){
        newBuffer[buffer.length-1-i] = buffer[i];
    }
    buffer = newBuffer;
}

public void draw(int indent){
    String indentString = createIndent(indent);
    for(String line: buffer){
         System.out.println(indentString + line);
    }
}

private String createIndent(int indent){
    String str = "";
    for(int i = 0; i < indent; i ++){
       str = str + " ";
    }
    return str;
}