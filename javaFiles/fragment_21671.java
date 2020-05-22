public List<DriversLicence> findDriversLicencesWith(List<LicenceClass> licenceClasses) {
    String hqlString = "select dl from DriversLicenceImpl dl where 1=1 ";
    for (int i = 0; i < licenceClasses.size(); i++) {
        hqlString += " and :licenceClass" + i + " = some elements(dl.licenceClasses)";
    }

    Query query = getSession().createQuery(hqlString);
    for (int i = 0; i < licenceClasses.size(); i++) {
        query.setParameter("licenceClass" + i, licenceClasses.get(i));
    }
    return query.list();
}