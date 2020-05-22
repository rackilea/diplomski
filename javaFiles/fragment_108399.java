Query q = new Query("Product");
    List<Entity> products = new ArrayList<Entity>();
    for (Entity entity : datastore.prepare(q).asIterable()) {
        entity.setProperty("sale", false);
        products.add(entity);
    }
    datastore.put(products);