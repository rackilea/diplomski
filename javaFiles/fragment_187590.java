public Basket(int weight, Fish fish) {
    this(weight, new Fish[] {fish};
    singleFish = true;
}

public Basket(int weight, Fish[] fishes) {
    singleFish = fishes.length == 1;
}