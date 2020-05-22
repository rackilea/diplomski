@Test
     public void getWarehousesByProduct() {

        Product drinks = new Product("drinks");

        Warehouse wh1 = new Warehouse("house1");
        Warehouse wh2 = new Warehouse("house2");
        Warehouse wh3 = new Warehouse("house3");
        Warehouse wh4 = new Warehouse("house4");
        Warehouse wh5 = new Warehouse("house5");
        Warehouse wh6 = new Warehouse("house6");

        drinks.getWarehouses().add(wh1);
        drinks.getWarehouses().add(wh2);
        drinks.getWarehouses().add(wh3);
        drinks.getWarehouses().add(wh4);

        saveAll(Arrays.asList(new Warehouse[]{wh1,wh2,wh3,wh4,wh5,wh6}));
        em.persist(drinks);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Warehouse> cq = cb.createQuery(Warehouse.class);
        Root<Product> product = cq.from(Product.class);
        Join<Product, Warehouse> warehouses = product.join("warehouses");
        cq.select(warehouses).where(cb.equal(product.get("id"), drinks.getId()));

        TypedQuery<Warehouse> tq = em.createQuery(cq);
        List<Warehouse> result = tq.getResultList();

        Assert.assertNotNull(result);
        Assert.assertEquals(drinks.getWarehouses().size(), result.size());
     }