@Override
    @Transactional
    public void updateStocksPrices(Stocks stocks) {
        Query query = entityManager.createNativeQuery("UPDATE stocks set price=:price WHERE id=:id");
        query.setParameter("price", stocks.getPrice());
        query.setParameter("id" stocks.getId());
        query.executeUpdate();
    }