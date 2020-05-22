[...]PreparedStatement ps = db.prepareStatement("INSERT INTO TMDB_TEST_MOVIES 
       (TMDB_ID, ORIGINAL_TITLE, IMDB_ID) VALUES (?,?,?)");[...]

[...]for (int i = 0; i < tmdb_max_id; i++) {

            try {

                MovieDb movie_name = movies.getMovie(i, "en");
                String original_title = movie_name.getOriginalTitle();
                String imdb_id = movie_name.getImdbID();

                  ps.setInt(1,i);
                  ps.setString(2,original_title);
                  ps.setString(3,imdb_id);
                  ps.executeUpdate();


                i++;

                } catch (RuntimeException e) {
                continue;
            } catch (SQLException sqle) {
                throw sqle;
            }

        }[...]