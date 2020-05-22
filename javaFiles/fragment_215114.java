for(String s : delimiters) {
    // We don't want to start with (|
    if (regexp.length() > 1)
    {
        regexp.append("|");
    }
    regexp.append(Pattern.quote(s));  
}