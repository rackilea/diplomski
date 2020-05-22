public TieredCake(Cake base, Cake top) {
    super(
        base.getName() + " with an upper tier of " + top.getName(),
        (base.getPrice() + top.getPrice()) * 1.1
    );

    this.base = base;
    this.top = top;
}