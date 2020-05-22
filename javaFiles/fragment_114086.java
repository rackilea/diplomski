public class DataTypeTest {

@Test
public void testDatatypeFromName() {
    DataType d = DataTypeUtil.fromString("Profile");
    assertTrue((d.toString().compareToIgnoreCase(DataType.PROFILE.toString()) == 0));
}

@Test(expected = IllegalArgumentException.class)
public void testDatatypeFromInvalidName()   {
    DataType d = DataTypeUtil.fromString("SupportDetail");
    assertFalse((d.toString().compareToIgnoreCase(DataType.SUPPORT_DETAIL.toString()) == 0));
}    

@Test
public void testDatatypeFromCorrectName()   {
    DataType d = DataTypeUtil.fromString("Support_Detail");
    assertTrue((d.toString().compareToIgnoreCase(DataType.SUPPORT_DETAIL.toString()) == 0));
}

@Test
public void testGetValueFromEnum() throws Exception {
    DataType dataType = DataType.valueOf("Profile".toUpperCase());
    assertTrue(dataType == DataType.PROFILE);
}