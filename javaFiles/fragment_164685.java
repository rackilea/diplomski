public Company getCompanyByNameAddressCellphone(String companyName, String address, Integer cellPhoneNumber) {
    Criteria criteria = getCurrentSession().createCriteria(Company.class);
    criteria.add(Restrictions.eq("companyName", companyName));
    criteria.add(Restrictions.eq("address", address));
    criteria.add(Restrictions.eq("cellPhoneNumber", cellPhoneNumber));
    return criteria.uniqueResult();
}