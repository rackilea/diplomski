public List<List<Integer>> parseRatingsFile(String fileName) throws IOException {
    List<List<Integer>> ratings2DArray = new ArrayList<List<Integer>>(16);

    final BufferedReader in = new BufferedReader(new FileReader(fileName));
    String ratingsLine = null;
    while ((ratingsLine = in.readLine()) != null) {
        ratings2DArray.add(parseRatingsLine(ratingsLine));
    }
    in.close();

    return ratings2DArray;
}

public List<Integer> parseRatingsLine(String ratingsLine) IOException {
    List<Integer> ratings = new ArrayList<Integer>(8);
    if(ratingsLine == null) return ratings;

    String[] ratingsStrArr = ratingsLine.split(" "); // Tokenize on 'space' character
    for(final String ratingStr: ratingsStrArr) {
        // Here you would parse the ratingStr as an Integer, and
        // add it to your list
    }

    return ratings;
}