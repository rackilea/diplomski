String data = "I need to purchase a new vehicle. I would prefer a BMW.";
Pattern patter =  Pattern.compile("(?<![a-z\\-_'])[a-z\\-_']{4,}(?![a-z\\-_'])",
        Pattern.CASE_INSENSITIVE);
Matcher matcher = patter.matcher(data);

StringBuffer sb = new StringBuffer();// holder of new version of our
                                        // data
while (matcher.find()) {// lets find all words
    // and change them with its upper case version
    matcher.appendReplacement(sb, matcher.group().toUpperCase());
}
matcher.appendTail(sb);// lets not forget about part after last match

System.out.println(sb);