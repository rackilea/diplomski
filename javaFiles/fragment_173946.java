Set<Product> products = new HashSet<Product>();
products.add(product);
if(getTeam(team.getTeamName()) != null) {
    product.setTeam(getTeam(team.getTeamName()));
    sessionFactory.getCurrentSession().saveOrUpdate(product);
} else {
    team.setProducts(products);
    sessionFactory.getCurrentSession().saveOrUpdate(team);
}