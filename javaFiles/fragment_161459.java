Map<Character, String> genres = new HashMap<Character, String>() {{
    put('b', "biographical");
    put('C', "Children");
    put('2', "Academy Award");
    // etc...
}};

String genre = "b2C";

List<String> info = new ArrayList<String>();
for (int i = 0; i < genre.length(); i++) {
    info.add(genres.get(genre.charAt(i));
}

System.out.println(StringUtils.join(info, ", "));

Outputs: biographical, Academy Award, Children