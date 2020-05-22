//Initliase graph
BaseConfiguration baseConfiguration = new BaseConfiguration();
baseConfiguration.setProperty("storage.backend", "cassandra");
baseConfiguration.setProperty("storage.hostname", "192.168.3.82");
baseConfiguration.setProperty("storage.cassandra.keyspace", "mycustomerdata");
TitanGraph graph = TitanFactory.open(baseConfiguration);

//---------------- Adding Data -------------------
//Create some customers
Vertex alice = graph.addVertex("customer");
alice.property("name", "Alice Mc Alice");
alice.property("birthdat", "100000 BC");

Vertex bob = graph.addVertex("customer");
bob.property("name", "Bob Mc Bob");
bob.property("birthdat", "1000 BC");

//Create Some Products
Vertex meat = graph.addVertex("product");
meat.property("name", "Meat");
meat.property("description", "Delicious Meat");

Vertex lettuce = graph.addVertex("product");
lettuce.property("name", "Lettuce");
lettuce.property("description", "Delicious Lettuce which is green");

//Alice Bought some meat:
alice.addEdge("bought", meat);
//Bob Bought some meat and lettuce:
bob.addEdge("bought", meat, lettuce);

//---------------- Querying (aka traversing whcih is what you do in graph dbs) Data -------------------
//Now who has bought meat?
graph.traversal().V().has("name", "meat").in("bought").forEachRemaining(v -> System.out.println(v.value("name")));

//Who are all our customers
graph.traversal().V().hasLabel("customer").forEachRemaining(v -> System.out.println(v.value("name")));

//What products do we have
graph.traversal().V().hasLabel("customer").forEachRemaining(v -> System.out.println(v.value("name")));