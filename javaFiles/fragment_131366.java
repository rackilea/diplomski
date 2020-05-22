public static StringBuilder printEmailsListFormat(List<String> a) {
    StringBuilder sb = new StringBuilder();
    Formatter formatter = new Formatter(sb);
    for(int i = 0; i < a.size(); i++) {
        formatter.format("%-45s", a.get(i));
        if(i % 3 ==0) sb.append("\n");
    }
    return sb;
}