Class mockClass = mock(Class.class);

when(mockClass.functionB(any(),any())).thenReturn(mockString);
when(mockClass.functionA(arguments)).thenCallRealMethod();

mockClass.functionA(arguments);