for(int i = 0; i < text.length; i++) {
    if(text[i] == 0) {
        text[i] = 32; 
    }
}
String result = new String(text, StandardCharsets.UTF_8);