String seperator = "|";
StringBuilder sb = new StringBuilder();

Set<String> keys = detailHashtable.keySet();
for(String key: keys) {
    sb.append(key+"="+detailHashtable.get(key)+ seperator);
}

return sb.toString();