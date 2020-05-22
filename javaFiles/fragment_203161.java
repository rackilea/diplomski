public List<Monuments> class MonumentsDAO() {
    public findAll(FilteredRequest filteredRequest){
        Criteria criteria = getSearchCriteria(filteredRequest);
        return list(criteria);
    }

    private Criteria getSearchCriteria(FilteredRequest filteredRequest){
        Criteria criteria = criteria();
        if (StringUtils.isNotEmpty(filteredRequest.getName())) {
            criteria.add(Restrictions.eq("name", filteredRequest.getName()));
        }
        if (StringUtils.isNotEmpty(filteredRequest.getCity())) {
            criteria.add(Restrictions.eq("city", filteredRequest.getCity()));
        }
        if (StringUtils.isNotEmpty(filteredRequest.getCategory())) {
            criteria.add(Restrictions.eq("category", filteredRequest.getCategory()));
        }
        return criteria;
    }
}