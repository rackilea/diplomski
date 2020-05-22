public static void main(String[] args) throws Exception {
    HibernateTemplate hibTemplate = new HibernateTemplate(getSessionFactory());
    hibTemplate.setCacheQueries(true);
    //System.out.println(hibTemplate.find("select a.bs from A a"));
    //System.out.println(hibTemplate.find("select a.bs from A a"));
    System.out.println(hibTemplate.find("select bs from A a inner join a.bs as bs"));
    System.out.println(hibTemplate.find("select bs from A a inner join a.bs as bs"));
}