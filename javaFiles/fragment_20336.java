public GridPageDet listFilter(DwrParam dwrParam,User user,Job job) throws Exception {   
        Query query = getSession().createSQLQuery(
        "select user_id from hs_cust_users where cust_id IN(select cust_id from hs_cust_users where user_id=:userId)").setParameter("userId", user.getId());
        Collection<Object> list = (Collection<Object>)query.list();
        List<Long> l=new ArrayList<Long>();     
        for(Object obj : list){         
            l.add(Long.parseLong(obj+""));
        }               
        GridPageDet gridPgeDet=new GridPageDet();
        Criteria criteria=getSession().createCriteria(Filter.class);
        criteria.createCriteria("filterQA.typeId", "filterQAType", Criteria.FULL_JOIN);
        criteria.add(Expression.eq("status", 1)); 
        if(user!=null && user.getId()!=null){
            Object statusArr [] = {1};
            criteria.createCriteria("user", "user", Criteria.FULL_JOIN);                
            criteria.add(Expression.in("status", statusArr));           
            if(user.getAccessGroupMap().getId().intValue() == Helper.ACCESS_GROUP_MAP_COMPANY_ADMIN_ID.intValue() || 
                    user.getAccessGroupMap().getId().intValue() == Helper.ACCESS_GROUP_MAP_COMPANY_DIRECTOR_USER_ID.intValue()){
                criteria.add(Expression.in("user.id", l));
            }else{
                criteria.add(Expression.eq("user.id", user.getId()));
            }
        }
        List<ExtJSGridFilter> extJsFilterList = (List<ExtJSGridFilter>)dwrParam.getFilter();
        int totalCount=criteria.list().size();
}