int i=0;
int batch = 100;
List<myNumber> numList = getEntityManager().createQuery("select t.myNumber from myTable t").setFirstResult(i).setMaxResults(batch).getResultList();

while(numList.size() == batch){
    //process numList
    i+=batch;
    numList = getEntityManager().createQuery("select t.myNumber from myTable t").setFirstResult(i).setMaxResults(batch).getResultList();    
}