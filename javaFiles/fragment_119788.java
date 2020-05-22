public List <Product> getProducts(String prodId, String prodName) {

    CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
    CriteriaQuery <Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);

    Root <Product> root = criteriaQuery.from(Product.class);

    List <Predicate> p = new ArrayList <Predicate> ();

    if(prodId != null){
         p.add(criteriaBuilder.like(root.get(Product_.prodId),prodId));
    }

    if(prodName != null){
         p.add(criteriaBuilder.like(root.get(Product_.prodName), prodName));
    }

    if(!p.isEmpty()){
        Predicate[] pr = new Predicate[p.size()];
        p.toArray(pr);
        criteriaQuery.where(pr);    
    }
    return getEntityManager().createQuery(criteriaQuery).getResultList();
}