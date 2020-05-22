// static import for Mockito.xxx needed

final Mutator mutator = mock(Mutator.class);

// Will return value1, then value2
when(mock.randomSynapseWeightChange())
    .thenReturn(value1)
    .thenReturn(value2)
    .etc().etc();