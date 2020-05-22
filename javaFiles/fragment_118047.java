String convertToSPARQLList(List<String> list) {
    StringBuffer sb = new StringBuffer();
    sb.append("(");
    for(String item: list) {
         sb.append("rec:" + item);
         sb.append(", ");
    }
    sb.setLength(sb.length() - 2); // remove last comma and whitespace
    sb.append(")");
    return sb.toString();
 }