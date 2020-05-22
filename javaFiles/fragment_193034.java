// \{variable=value#if_true#if_false\}
Pattern pattern = Pattern.compile(Pattern.quote("\\{") + "([\\w\\s]+)=([\\w\\s]+)#([\\w\\s]+)#([\\w\\s]+)" + Pattern.quote("\\}"));
Matcher matcher = pattern.matcher(doc);

// if we'll make multiple replacements we should keep an offset
int offset = 0;

// perform the search
while (matcher.find()) {
    // by default, replacement is the same expression
    String replacement = matcher.group(0);
    String field = matcher.group(1);
    String value = matcher.group(2);
    String ifTrue = matcher.group(3);
    String ifFalse = matcher.group(4);

    // verify if field is gender
    if (field.equalsIgnoreCase("Gender")) {
        replacement = value.equalsIgnoreCase("Female")?ifTrue:ifFalse;
    }

    // replace the string
    doc = doc.substring(0, matcher.start() + offset) + replacement + doc.substring(matcher.end() + offset);

    // adjust the offset
    offset += replacement.length() - matcher.group(0).length();
}