@Transactional
public List<Result> getClassificationOfPta() {

    String hql = "select new com.myapp.Result(p as pta, c as classPta) 
         from Pta p join p.classePta c where c.niveau = 2 order by p.creation";

    Session sessionDynamic = Utils.createDynamicSession(env);

    Query query = sessionDynamic.createQuery(hql);

    List<Result> list = (List<Result>) query.list();

    sessionDynamic.close();

    return list;

}