Mockito.when(dpDaoMock.save(Matchers.argThat(new ArgumentMatcher<DPModel>() {
    @Override
    public boolean matches(Object argument) {
        DPModel dpModel = (DPModel) argument;
        return dpModel.getDpId().equals(123L);
    }
}))).thenReturn(dpModel2);