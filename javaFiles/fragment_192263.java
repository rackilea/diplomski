SomeClass mock = mock(SomeClass.class);
when(mock.validatePersonForBenefitsProcessing(any(PersonDTO.class))).thenAnswer(new Answer<Boolean>() {

    @Override
    public Boolean answer(InvocationOnMock invocation) throws Throwable {

        PersonDTO dto = (PersonDTO) invocation.getArgument(0);
        dto.setSendPersonToInternal(true);

        return true;
    }
});