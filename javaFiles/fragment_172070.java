@Override
@Transactional(rollbackFor = StockException.class)
public void removeCategoriesToStock(Set<Integer> categoryCodes, Integer codStock) throws StockException{
    //I get the stock that I will disassociate
    Stock stock = sessionFactory.getCurrentSession().get(Stock.class, codStock);
    if (categoryCodes != null) {
    //For each category to eliminate the stock, I consult and eliminate the relationship in both entities
        for (Integer codCategory : categoryCodes) {
            Category category = sessionFactory.getCurrentSession().get(Category.class, codCategory);
            category.remove(stock);
            stock.remove(category);
        }
    }
    sessionFactory.getCurrentSession().merge(stock);
    sessionFactory.getCurrentSession().flush();
}