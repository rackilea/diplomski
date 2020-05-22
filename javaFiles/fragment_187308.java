Criteria criteriaQuery = session.createCriteria(Product.class);

 Restrictions<Product> restrictions = Restrictions.create(Product.class);
 Product example = restrictions.getQueryObject();
 example.setName(restrictions.like("N%"));
 example.setPromo("Discounts up to 10%");

 restrictions.addRestrictions(criteriaQuery);