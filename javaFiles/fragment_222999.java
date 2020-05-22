class Dispatcher {
    Map<Factory<?>, MyQueue<?>> workQueues = new HashMap<Factory<?>, MyQueue<?>>();

    @SuppressWarnings("unchecked")
    public <ProductType extends Product<ProductType>> void addNextOrder(OrderSystem orderSystem) {
        ProductType nextProduct = orderSystem.getNextProduct();
        MyQueue<ProductType> myQueue = (MyQueue<ProductType>) workQueues.get(nextProduct.getFactory());
        myQueue.add(nextProduct);
    }       

    public void assignWork() {
        for (Factory<?> factory: workQueues.keySet())
            if (!factory.isBusy())
                buildProduct(workQueues.get(factory).poll());
    }

    public <ProductType extends Product<ProductType>> void buildProduct(ProductType product) {
        product.getFactory().buildProduct(product);
    }
}