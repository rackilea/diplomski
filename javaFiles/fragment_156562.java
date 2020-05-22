@Test
public void setStaticField(@Mocked JdbcTemplate mockTemplate)
{
    Deencapsulation.setField(ClassUnderTest.class, mockTemplate);

    assertSame(mockTemplate, ClassUnderTest.getJdbcTemplate());
}