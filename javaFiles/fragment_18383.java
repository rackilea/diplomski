while (matcher.find()) {
    if (!matcher.group(1).trim().isEmpty()){
        tagValues.add(matcher.group(1));
        count++;
    }
}