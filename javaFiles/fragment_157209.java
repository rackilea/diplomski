LinkedList<String> genres = new LinkedList<String>();
        genres.add("Action");
        genres.add("Adventure");
        genres.add("Comedy");
        genres.add("Animation");
        genres.add( "Drama");
        genres.add("Romance");
        .
        .
        .

     LinkedHashMap<String,Integer> currentGenreHashMap = new LinkedHashMap<String, Integer>();
     String baseUrl = "http://www.imdb.com/title/"+ImdbID;

            try {
               org.jsoup.Connection con = Jsoup.connect(baseUrl).userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21");
              ....
              ..
                   Elements elms1 = doc.select("div.infobar");  
                    Elements links1 = elms1.select("a[href]");
                    LinkedList<String> currentGenres = new LinkedList<String>();


                   for (String g1 : genres){
                        currentGenreHashMap.put(g1, 0);
                    } //set the default to zero


                    for(Element link1 : links1){
                        if(link1.attr("href").contains("/genre/"))
                        {
                            currentGenres.add(link1.text());
                            System.out.println("generi: " + link1.text());
                        }
                    }

                    for (String genere : genres){
                        if (currentGenres.contains(genere))
                            currentGenreHashMap.put(genere, 1);

                        } //here I compare the genre that I get by crawler to the genres in the list and when they were equal it set it to '1'
                        System.out.println("movie genres:" + currentGenreHashMap);
                          ...
                          ...
                     try{
                        String query = "INSERT into moviesInfo (movieImdbId, Action, Adventure, Comedy, Animation, Drama, Romance, Family, Fantasy, Crime, Biography, Documentary, FilmNoir, Horror, War, History, Western, Musical, SciFi, Mystery, Thriller, RealityTV, TalkShow, GameShow, Short, Music, Sport, News, Adult, Lifestyle, Experimental, Commercial, country, trailerLink, storyline, posterLink)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString (1, ImdbID);
                        int count = 2;
                        for (String g1 : currentGenreHashMap.keySet()){

                            preparedStmt.setString (count, currentGenreHashMap.get(g1).toString());
                            count++;
                        }
                      preparedStmt.executeUpdate();

                    }catch (Exception e)
                    {
                        System.err.println("Got an exception!");
                        System.err.println(e.getMessage()); 
                    }