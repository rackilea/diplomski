when(moStore.add(eq(expectedKey), eq(mo))).thenThrow(new RuntimeException());

processor.setMoStore(moStore);
MyObject mo = new MyObject();
mo.setEmail("abc@123");
mo.setId("123");
moList.add(mo);