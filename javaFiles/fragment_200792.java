public static PostSearchAdapter create(Context context, int resultType){
    switch (resultType){
        case 0:
            return new TrackAdapter(context);
        case 1:
            return new AlbumAdapter(context);
        default:
            throw new IllegalArgumentException("Invalid resultType:"+resultType);
    }
}