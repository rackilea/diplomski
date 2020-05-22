session.createCriteria(Item.class) 
        .createAlias("item", "i") 
        .setProjection( Projections.projectionList() 
            .add( Projections.groupProperty("i.id") ) 
            .add( Projections.groupProperty("i.price") ) 
            .add( Projections.groupProperty("i.quantity") ) 
            .add( Projections.sqlProjection( 
                    "price * quantity as total", 
                    new String[] { "total" }, 
                    new Type[] { Hibernate.DOUBLE } 
                  ) 
            ) 
        );