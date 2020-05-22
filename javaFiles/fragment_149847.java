class Product {
    @OneToMany
    List<Price> prices;

    Optional<Price> getCurrentPrice() {
        prices.stream().filter(p->p.status==ACTIVE).findFirst();
    }
}