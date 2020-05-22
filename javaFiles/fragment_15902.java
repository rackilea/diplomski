public double getTotalValue(List<CartLine> cartLineList) {
    double results = 0;
    for(CartLine cartLine: getCartLineList()){
        results += (cartLine.getQuantity() * cartLine.getProduct().getPrice());
    }
    return results;
}