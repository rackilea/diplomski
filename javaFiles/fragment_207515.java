EntityGraph<Product> graph = this.em.createEntityGraph(Product.class);
graph.addAttributeNodes("tags"); //here you can add or not the tags

Map<String, Object> hints = new HashMap<String, Object>();
hints.put("javax.persistence.loadgraph", graph);

this.em.find(Product.class, orderId, hints);