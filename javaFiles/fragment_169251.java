@Test
public void should_store_new_verfahren_to_persistence_layer(@Injectable final EntityManager em){


    List<Verfahren> listeMitEinemNeuenVerfahren = new ArrayList<Verfahren>();
    Verfahren v = new Verfahren();
    v.setId(0);
    v.setExterneId("Neu");
    v.setFremdsystem(Verfahren.FREMDSYSTEM_P);
    listeMitEinemNeuenVerfahren.add(v);


    new NonStrictExpectations(archiveService) { 
        {
            archiveService.getVerfahrenByExterneID(anyString, anyString);result = null;
        }
    };

    new Expectations() {
        {
            em.persist(any);
        }
    };

    archiveService.storeAndUpdateVerfahren(listeMitEinemNeuenVerfahren);

}