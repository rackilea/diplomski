public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    for (int i=0 ; i<10000 ; i++) {
        sb.append("really ");
    }
    sb.append("long string.");
    String s = sb.toString();
}