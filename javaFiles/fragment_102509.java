public String createNotification(){
    Pattern pattern = Pattern.compile("\\[(.+?)\\]");
    Matcher matcher = pattern.matcher(textTemplate);
    HashMap<String,String> replacementValues = new HashMap<String,String>();
    StringBuilder builder = new StringBuilder();
    int i = 0;
    while (matcher.find()) {
        String replacement = replacementValues.get(matcher.group(1));
        builder.append(textTemplate.substring(i, matcher.start()));
        if (replacement == null){ builder.append(matcher.group(0)); }      
        else { builder.append(replacement); }     
        i = matcher.end();
    }
    builder.append(textTemplate.substring(i, textTemplate.length()));
    return builder.toString()
}