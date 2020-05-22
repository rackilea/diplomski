when(mockB.getName()).thenReturn("fred");

when(mockA.getB()).thenReturn(mockB);

when(mockB.getAge()).thenReturn(23);
...
mockB = null