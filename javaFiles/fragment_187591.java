private final Fish[] fishes;
private final boolean singleFish;

public Basket(int weight, Fish... fishes) {
    this.fishes = fishes;
    singleFish = fishes.length == 1;
}

new Basket(45, hering, sardine, riba);
new Basket(75, shark);