public void storeProducts( final Product product, final int count ) {

    Session session = getSessionFactory().getCurrentSession();

    WarehouseProduct productToStore = (WarehouseProduct) session.get(  WarehouseProduct.class,
            String.valueOf( product ) );
    productToStore.setProductCount( productToStore.getProductCount() + count );
    session.update( productToStore );

}