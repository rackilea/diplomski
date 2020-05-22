//The Graph Store protocol for sem_tutorials (my dummy dataset) is http://localhost:3030/sem_tutorials/data
private static final String FUSEKI_SERVICE_DATASETS_URI = "http://localhost:3030/sem_tutorials/data";
private void testSavingModel(OntModel model){
  DatasetAccessor accessor = DatasetAccessorFactory.createHTTP(FUSEKI_SERVICE_DATASETS_URI);
 if(accessor != null){
    //because I already had a number of Triples there already - I am only adding this model
    accessor.add(model);
  }
}