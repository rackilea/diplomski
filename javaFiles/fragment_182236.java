public static void main(String[] args) {
    String search_query = "one two three";
    String[] queries = search_query.split(" ");

    List<String> liste = new ArrayList<>();

    for (int i = 0; i < queries.length; i++) {
        String query  = "";
        for (int j = i; j < queries.length; j++) {
            query  += queries[j] + " ";
            liste.add(query);
        }
    }

    for (String y : liste) {
        System.out.println(y);
    }
}