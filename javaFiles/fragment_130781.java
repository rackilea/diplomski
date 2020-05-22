@Test
    public void testConstructorIsPrivate() throws Exception {
      Constructor constructor = Product.class.getDeclaredConstructor();
      assertTrue(Modifier.isPrivate(constructor.getModifiers()));
      constructor.setAccessible(true);
      constructor.newInstance();
    }