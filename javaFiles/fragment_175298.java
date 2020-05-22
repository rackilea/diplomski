List<Date> listeDate = new ArrayList<>();

List<DemoTableEntity> list = query.getResultList();

for(DemoTableEntity ent : list){
   listeDate.add(ent.getRowCreated());
}