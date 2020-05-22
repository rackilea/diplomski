public static void main(String[] args) throws Exception {
    String q = "How, how to change my password?";
    q = q.replace(" ", "-").replaceAll("[^a-zA-Z-]", "");
    String url = URLEncoder.encode(q, "UTF-8");
    System.out.println(url);
}