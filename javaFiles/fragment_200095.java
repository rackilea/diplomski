@ApiMethod(name = "getGamesOffThePodium", path = "get_games_off_the_podium")
    public CollectionResponse<MGameResult> getGamesOffThePodium(@Nullable @Named("cursor") String cursorString, @Nullable @Named("limit") Integer limit) {
}

@ApiMethod(name = "getGamesWon", path = "get_games_won")
    public CollectionResponse<MGameResult> getGamesWon(@Nullable @Named("cursor") String cursorString, @Nullable @Named("limit") Integer limit) {
    }

@ApiMethod(name = "getGamesUnsolved", path = "get_games_unsolved")
    public CollectionResponse<MGameResult> getGamesUnsolved(@Nullable @Named("cursor") String cursorString, @Nullable @Named("limit") Integer limit) {
}