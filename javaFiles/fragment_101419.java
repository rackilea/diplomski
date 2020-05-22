public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();

    session.beginTransaction();

    PetTypes dog = new PetTypes();
    dog.setName("Dog");
    dog.setId(1);
    PetTypes cat = new PetTypes();
    cat.setName("Cat");
    cat.setId(2);

    session.save(dog);
    session.save(cat);

    int id = 1;
    Pets joe = new Pets();
    joe.setId(id++);
    joe.setDescription("Joe");

    Pets x = new Pets();
    x.setId(id++);
    x.setDescription("Sarah");    
    x.setPetTypes(dog);

    Pets y = new Pets();
    y.setId(id++);
    y.setDescription("Jakob");    
    y.setPetTypes(cat);  

    Pets z = new Pets();
    z.setId(id++);
    z.setDescription("Xena");    
    z.setPetTypes(cat);                

    session.save(joe);
    session.save(x);
    session.save(y);
    session.save(z);

    session.getTransaction().commit();

    Query q = session.createQuery("select p from Pets p "
            + "left join p.petTypes pt "
            + "order by case when pt is null then 0 else 1 end, pt.name ");

    List<Pets> resultList = q.list();
    System.out.println("num of employess:" + resultList.size());
    for (Pets next : resultList) {
        System.out.println("pet " + next);
    }
}