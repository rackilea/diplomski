String[] splitElements(String source) {
    int parencount = 0;
    boolean q = false;
    List<String> l = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < source.length(); i++) {
        char c = source.charAt(i);
        switch (c) {
            case ',':
                if (!q && parencount == 0) {
                    l.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }
                break;

            case '(':
                if(!q) parencount++;
                sb.append(c);
                break;

            case ')':
                if(!q) parencount--;
                sb.append(c);
                break;

            case '\'':
                q = ! q;
                sb.append(c);
                break;

            default:
                sb.append(c);
                break;
        }
    }
    String last = sb.toString();
    l.add(last);
    String sa[] = l.toArray(new String[l.size()]);
    return sa;
}