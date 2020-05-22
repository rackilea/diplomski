static List<String> exclude = Arrays.asList("Parameters");

static String getReplacement(String in) {
    for(String ex : exclude) {
        if(in.startsWith(ex + "."))
            return in;
    }

    StringBuffer b = new StringBuffer();
    Matcher m = Pattern.compile("_(.)").matcher(in);
    while(m.find()) {
        m.appendReplacement(b, m.group(1).toUpperCase());
    }

    m.appendTail(b);
    return b.toString();
}

static String stripUnderscores(String line) { 
    Pattern p = Pattern.compile("([_$\\w][_$\\w\\d]+\\.?)+");
    Matcher m = p.matcher(line);         
    StringBuffer sb = new StringBuffer(); 
    while(m.find()) { 
        m.appendReplacement(sb, getReplacement(m.group())); 
    } 
    m.appendTail(sb); 
    return sb.toString(); 
}