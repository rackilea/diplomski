// if you want to write empty string to doc file where there isn't any match
private static final List<String> NOT_ANY_MATCHED = new ArrayList<String>(){{ add(""); }}; 
if (paragraphs.length > 0) {
    List<String> matches = new ArrayList<>();
    for( String para : paragraphs ) {
        para = para.trim();
        if(para.contains(key)) { 
            matches.add(para);
        }
    }
    if (matches.size() > 0){
        writeDocFile(matches);
    }
    esle {
        writeDocFile(NOT_ANY_MATCHED);
    }
}