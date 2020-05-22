public String findKeyWord() throws BadLocationException {
    if( textArea.getText().isEmpty() )
        return "";

    String keyWord = "";
    for( String line : textArea.getText().split("\n")){
        if( !line.startsWith("#") ){
            int keywordEndPosition = line.indexOf("#"); 
            keyWord = line.substring(0, keywordEndPosition == -1 ? line.length() : keywordEndPosition );
            keyWord = keyWord.trim();
            break;
        }
    }

    return keyWord;
}