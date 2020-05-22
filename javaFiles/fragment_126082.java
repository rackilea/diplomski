Query query = session.createQuery(" from SalesForecast salesforcast where
                                  salesforcast.ppUserMobile ='" + mobile + "' ");
    List results = query.list();
    if(results!=null){
        return results.get(0);
    } else{
        return null;
    }