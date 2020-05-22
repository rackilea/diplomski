String sql = "select c.f_user_name as userName, d.f_country_code as \"addressDetails.countryCode\" "
        + "from customers c left outer join address_details d on c.fk_details = d.f_pid";

List<Customer> customers = session.createSQLQuery(sql)
        .setResultTransformer(new FluentHibernateResultTransformer(Customer.class))
        .list();