static final String EMPTY_CELL = String.format("%45s", ""); //JDK11: " ".repeat(45);

public static StringBuilder printEmailsListFormat(List<String> a) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < a.size(); i++) {
        String s = a.get(i);
        sb.append(s);
        if(s.length() < EMPTY_CELL.length())
            sb.append(EMPTY_CELL, s.length(), EMPTY_CELL.length());
        if(i % 3 ==0) sb.append("\n");
    }
    return sb;
}