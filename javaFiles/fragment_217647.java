public static void main(String[] args) {
    String str = "Bob went to \"the store\" the store to \"buy milk\" buy milk.";
    boolean inQuotes = false;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '"') inQuotes = !inQuotes;
        else if (!inQuotes) sb.append(str.charAt(i));
    }
    System.out.println(sb.toString());
}