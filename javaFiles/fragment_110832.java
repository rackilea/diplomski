PricingFromS4Request pricingRequest = new PricingFromS4Request();
    ProductFromS4Request productRequest = new ProductFromS4Request();
    PricingFromS4ServiceImpl service = new PricingFromS4ServiceImpl();

    ExecutorService executor = Executors.newFixedThreadPool(2);

    Future<PricingFromS4Request> f1 = executor.submit(new Callable<PricingFromS4Request >() {
        public PricingFromS4Request  call() {
            return service.createS4PricingRequest(ABeanObject, SomeArrayList);
        }
    });
    Future<ProductFromS4Request> f2 = executor.submit(new Callable<ProductFromS4Request>() {
        public ProductFromS4Request call() {
            return service.createS4ProductRequest(SomeList);
        }
    });
    SomeMethod(f1.get(), f2.get());
    executor.shutdown();