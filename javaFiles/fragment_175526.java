Criteria criteria = this.getSession().createCriteria(Articulo.class, "articulo")
                             .createAlias("articulo.poblacionList", "poblacion");

//... your projections or something else

criteria.addOrder(Order.asc("poblacion.nombre")); //using the alias.