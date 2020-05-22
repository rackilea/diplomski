MyClass abc = new MyClass();

EasyMock.expect(mockEntityManager.find(MyClass.class,111L)).andThrow(new SecurityException());

EasyMock.replay(mockEntityManager);

Object target = abc.getAsObject(mockFacesContext, mockUiComponent,"111");

Assert.assertEquals(null, target);