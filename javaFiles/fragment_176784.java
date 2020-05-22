// renamed itr to cartItr
// added final modifier to prevent re assignment.
final Iterator cartItr = cart.iterator();
while (cartItr.hasNext()) {
    Integer i = (Integer) cartItr.next();    
    LOG.info("Poduct Id " + i);
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<ProductBean> citeriaQuery = builder.createQuery(ProductBean.class);
    Root<ProductBean> root = citeriaQuery.from(ProductBean.class);
    citeriaQuery.select(root);
    citeriaQuery.where(builder.equal(root.get("product_id"), i));
    Query<ProductBean> query = session.createQuery(citeriaQuery);
    productBeanList = query.list();                
    for (ProductBean productBean : productBeanList) {
        StringBuilder sb = new StringBuilder();
        sb.append(productBean.getProduct_size());
        String[] lines = sb.toString().split(", ");                    
        for (String s : lines) {                       
            // added extra iterator variable sizesItr only visible in this for-block.
            // added final modifier to prevent re assignment.
            final Iterator sizesItr = sizes.iterator();
            while (sizesItr.hasNext()) {
                Object size = (Object) sizesItr.next();                            
                if (String.valueOf(size).equals(s)) {
                    LOG.info("If condition matches " + String.valueOf(size) + " id is " + i);
                    productMap = new HashMap();
                    productMap.put("productBeanSize", String.valueOf(size));
                    productMap.put("productBean", productBean);
                    productList.add(productMap);
                }
            }
        }
    }
}