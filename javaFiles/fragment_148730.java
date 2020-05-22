Observable<Tile> searchTile = getSearchResults("search term");;

    Observable<TileResponse> populatedTiles = searchTile.flatMap(t -> {
        Observable<Reviews> reviews = getSellerReviews(t.getSellerId());
        Observable<String> imageUrl = getProductImage(t.getProductId());

        return Observable.zip(reviews, imageUrl, (r, u) -> {
            return new TileResponse(t, r, u);
        });
    });

    List<TileResponse> allTiles = populatedTiles.toList()
            .toBlocking().single();