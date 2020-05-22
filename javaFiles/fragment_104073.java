Criteria crit = sess.createCriteria(Product.class);
if (productNameCriteria.equalsIgnoreCase("IS"))
    crit.add( Restrictions.eq("productName", productName);
else if (productNameCriteria.equalsIgnoreCase("BEGINS WITH"))
    crit.add( Restrictions.like("productName", productName + "%")
// etc