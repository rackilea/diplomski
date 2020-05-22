RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(new GsonBuilder()).create()))
                .setEndpoint("http://api.themoviedb.org")
                .build(); 
                 GitMovieApi git = restAdapter.create(GitMovieApi.class);