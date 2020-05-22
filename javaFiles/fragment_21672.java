for (LicenceClass licenceClass : licenceClasses) {               
    criteria.add(Restrictions.sqlRestriction("? = some(select " + LicenceClass.PRIMARY_KEY + " from " +
                    LICENCE_CLASS_JOIN_TABLE + "  where {alias}." +
                    DriversLicence.PRIMARY_KEY + " = " + DriversLicence.PRIMARY_KEY + ")",
                    licenceClass.getId(), Hibernate.LONG));
}