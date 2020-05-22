@PostConstruct
public init() {

    Query q = em.createQuery("select d.dName from District d",District.class);
    districtValues = q.getResultList();

    for(String d:districtValues){
        System.out.println(d);
    }
}