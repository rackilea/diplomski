public Supplier findByKey(Long id)
{
    Supplier result = (Supplier) getSession().find(Supplier.class, id);
    Hibernate.initialize(result.getIngredients());
    return result;
}