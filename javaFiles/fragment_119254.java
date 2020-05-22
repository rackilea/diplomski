when(foo.baz(anyInt())).thenReturn("A", "B");  /* or .thenReturn("A").thenReturn("B"); */
when(foo.baz(9)).thenReturn("X", "Y");

foo.baz(6); /* "A" because anyInt() is the last-defined chain */
foo.baz(7); /* "B" as the next return value of the first chain */
foo.baz(8); /* "B" as Mockito repeats the final chain action forever */

foo.baz(9); /* "X" because the second chain matches for the value 9 */
foo.baz(9); /* "Y" forever because the second chain action still matches */