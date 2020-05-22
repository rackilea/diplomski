@Test
    public void testFive(){
        Person mockedPerson = Mockito.mock(Person.class);
        Mockito.when(mockedPerson.getAge()).thenReturn(1,2,3,4);
        Mockito.when(mockedPerson.getName()).thenReturn("1","2","3");

        InOrder inOrder = Mockito.inOrder(mockedPerson);

        mockedPerson.getAge();
        mockedPerson.getAge();
        mockedPerson.getAge();

        mockedPerson.getName();
        mockedPerson.getName();
        mockedPerson.getName();

        mockedPerson.getAge();


        inOrder.verify(mockedPerson, times(3)).getAge();
        inOrder.verify(mockedPerson, times(3)).getName();
        inOrder.verify(mockedPerson, times(1)).getAge();
    }