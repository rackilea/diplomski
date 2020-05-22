public TieredCake(Cake base, Cake top) {
    super(
        base.getName() + " with an upper tier of " + top.getName(),
        (base.getPrice() + top.getPrice()) * 0.10 + base.getPrice() + top.getPrice()
    );

    this.base = base;
    this.top = top;
}