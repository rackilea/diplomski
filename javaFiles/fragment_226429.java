StringBuffer result = new StringBuffer();
while (abbrev_matcher.find()) {
    abbrev_matcher.appendReplacement(result, "");
    result.append(abbrev_matcher.group().replaceAll("\\.", ""));
}
abbrev_matcher.appendTail(result);