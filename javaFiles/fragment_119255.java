/* BAD: the call to foo.bar(1) will throw before Mockito has a chance to stub it! */
when(foo.bar(anyInt())).thenThrow(new IllegalArgumentException());
when(foo.bar(1)).thenReturn(99);

/* GOOD: Mockito has a chance to deactivate behavior during stubbing. */
when(foo.bar(anyInt())).thenThrow(new IllegalArgumentException());
doReturn(99).when(foo).bar(1);