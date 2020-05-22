@Override
@Transactional(rollbackFor = StockException.class)
public void addCategoriesToStock(Set<Integer> categoryCodes, Integer codStock) throws StockException{
    //I get the stock I'm going to associate
    Stock stock = sessionFactory.getCurrentSession().get(Stock.class, codStock);
    if (categoryCodes != null) {
    //For each category to add to the stock, I consult and add the relationship in both entities
        for (Integer codCategory : categoryCodes) {
            Category category = sessionFactory.getCurrentSession().get(Category.class, codCategory);
            category.add(stock);
            stock.add(category);
        }
    }
    sessionFactory.getCurrentSession().merge(stock);
    sessionFactory.getCurrentSession().flush();
}