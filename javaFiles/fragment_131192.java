// create a repository
Repository store = new SailRepository(new MemoryStore());
store.initialize();

// wrap in an object repository
ObjectRepositoryFactory factory = new ObjectRepositoryFactory();
ObjectRepository repository = factory.createRepository(store);