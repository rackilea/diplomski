public void test() {
    PersonDTO personMock = mock(PersonDTO.class);

    when(personMock.isPersonOnLeave()).thenReturn(true);
    when(personMock.isBenefitsCoverage()).thenReturn(true);
    when(personMock.isPersonOnSTD()).thenReturn(false);

    Assert.assertTrue(validatePersonForBenefitsProcessing(personMock));

    ArgumentCaptor<Boolean> captor = ArgumentCaptor.forClass(Boolean.class);
    verify(personMock).setSendPersonToInternal(captor.capture());

    Assert.assertTrue(captor.getValue());
}