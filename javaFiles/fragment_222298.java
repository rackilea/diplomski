add(new ListView("movie_list", movies) {

    @Override
    protected void populateItem(ListItem item) {
        final Movie movie = (Movie) item.getModelObject();
        Link link = new Link("movie_link") {

            @Override
            public void onClick() {
                setResponsePage(new MoviePage(movie));
            }
        };
        item.add(link);
        link.add(new Label("year", Integer.toString(movie.getYear())));
        link.add(new Label("year", Integer.toString(movie.getYear())));
    }
});