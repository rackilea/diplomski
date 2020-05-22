Criteria criteria = session.createCriteria(Activity.class) 
       .createAlias("activityLocations", "actloc") 
       .createAlias("actloc.location", "location");

Criteria addr = criteria.createCriteria("location.address"); 
addr.add((Restrictions.and(Restrictions.between("latitude", latmin,      
       latmax), Restrictions.between("longitude", truelongmin, truelongmax)))); 

String sql =  "SQRT( POW( 69.1 * ( {alias}.latitude - " + point[1]      
       +" ) , 2 ) + POW( 69.1 * ( "+point[0] +" - {alias}.longitude ) * COS( {alias}.latitude /" 
       +" 57.3 ) , 2 ) )  < "+distance;     
addr.add(Restrictions.sqlRestriction(sql));