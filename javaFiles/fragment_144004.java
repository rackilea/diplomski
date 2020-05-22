class GoodPackage extends Goods {
    private List<? extends Goods> goodsInside;

    @Override
    public Integer interpret(CurrentPricesContext context) {
        int totalSum = 0;
        for (Goods goods : goodsInside) {
            totalSum += goods.interpret(context);
        }
        return totalSum;
    }

    public List<? extends Goods> getGoodsInside() {
        return goodsInside;
    }

    public void setGoodsInside(List<? extends Goods> goodsInside) {
        this.goodsInside = goodsInside;
    }
}