if(coveredZipcodes.size()>0) {
        q.append(" and substring(zipcode,5,9) in (:zipcodes)");
    }
    q.append(" group by vehicle");

    Query query = sessionFactory.getCurrentSession().createQuery(q.toString());
    if(coveredZipcodes.size()>0)
        query.setParameterList("zipcodes", coveredZipcodes);

    List<Vehicle> vehicles = query.setFirstResult(from).setMaxResults(10).list();
    return vehicles;