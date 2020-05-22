Matcher matcher = Pattern.compile("(?<=@)\\w+").matcher(textStr);
while (matcher.find()){
    if (!mergedStr.isEmpty())
      mergedStr += ",";
    mergedStr += matcher.group();
}