@Test
public void mockAbstractClass(@NonStrict final PsActionBeanContext mock)
{
    final Brand brand = new Brand();
    brand.setBrandId(TESTUSER_BRAND_ID);

    new Expectations() {{ mock.getBrand(); result = brand; }};

    assertSame(brand, mock.getBrand());
}