@Test
public void testReceivePerson(){
    context.checking(new Expectations() {{          
        atLeast(1).of(person).getId();
        will(returnValue(String.class));        
    }});
    receiver.get(person);
}