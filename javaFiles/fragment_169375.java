private MediaSource buildMediaSource(Uri uri){    
        return new ExtractorMediaSource(uri,
                new DefaultDataSourceFactory(context,"ua"),
                new DefaultExtractorsFactory(),null,null);

    }