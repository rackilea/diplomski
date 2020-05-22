case R.id.bGo:
    new RequestTask()
            .execute("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey="
                    + API_KEY
                    + "&q="
                    + URLEncoder.encode(searchBox.getText(), "UTF-8")
                    + "&page_limit=" + MOVIE_PAGE_LIMIT);