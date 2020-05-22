public static void main(String[] args) throws Exception {
    Hatchery hatchery = new WorkerHatchery();
    Worker<ConfiguredProduct<String>> worker = hatchery.breed();
    ConfiguredProduct<String> product = worker.produce();
    worker.consume(product);
}