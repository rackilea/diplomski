StringBuilder sb = new StringBuilder();
boolean isFirst = true;
for(String word : stringList) {
    if (!isFirst) {
        sb.append('|');
    } else {
        isFirst = false;
    }
    sb.append("\\Q");
    sb.append(word);
    sb.append("\\E");
}
String regex = "myString/" + "(?:" + sb + ")";