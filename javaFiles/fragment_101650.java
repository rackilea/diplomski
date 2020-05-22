@InjectMocks
private Service service;

...

when(service.getByName("NAME", "YYY", Float.class)).thenReturn(randomNumber);