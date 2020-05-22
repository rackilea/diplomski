Project project = ...    

EntityManager manager = EasyMock.createStrictMock(EntityManager.class); 
ClassUnderTest test = new ClassUnderTest(manager)

//You expect this to be called    
manager.persist(project);

EasyMock.replay(manager);

//The method you are testing
test.save(project);

EasyMock.verify(manager);