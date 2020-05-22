try { // try to read the file 
    br = new BufferedReader(new FileReader("movies.txt"));
    String line; int numberOfMovies = 0;
    while (br.hasNextLine()){
        numberOfMovies++;
    }
    br.close();
    Movie[] movies = new Movie[numberOfMovies];
    // store in a Movie
    // array every movie of
    // the file
    String title = "";
    int id = 0;
    int likes = 0;
    int icounter = 0;
    // count to create new movie for each line
    br = new BufferedReader(new FileReader("movies.txt"));
    while ((br.hasNextLine()) {
        line = line.trim();
        line = line.replaceAll("/t", "");
        line = line.toLowerCase();
        String[] tokens = line.split(" ");
        // store every token in a
        // string array
        id = Integer.parseInt(tokens[0]);
        likes = Integer.parseInt(tokens[tokens.length]);
        for (int i = 1; i < tokens.length; i++) {
            title = title + " " + tokens[i];
        }
        movies[icounter] = new Movie(id, title, likes);
        icounter++;
    }
} catch (IOException e) { e.printStackTrace(); }