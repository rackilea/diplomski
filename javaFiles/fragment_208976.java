You can always write such test cases to make sure your mapping are good!
// Using EasyMock to mock FieldSet  
@Test
public void mapFieldSetTest()
{
    FieldSet mockFieldSet = EasyMock.createMock(FieldSet.class);

    EasyMock.expect(mockFieldSet.readString("LNAME")).andReturn("Doe");
    EasyMock.expect(mockFieldSet.readString("FNAME")).andReturn("John");
    EasyMock.expect(mockFieldSet.readString("ETYPE")).andReturn("PART-TIME");
    EasyMock.expect(mockFieldSet.readString("FADDRESS")).andReturn("191, Santa Clara");
    EasyMock.expect(mockFieldSet.readString("EMAIL")).andReturn("john.Doe@fb.com");
    EasyMock.expect(mockFieldSet.readString("UPN")).andReturn("1111111111");
    EasyMock.expect(mockFieldSet.readString("WFID")).andReturn("22222222");
    EasyMock.expect(mockFieldSet.readString("INS")).andReturn("CA University College");
    EasyMock.expect(mockFieldSet.readString("PIC")).andReturn("c:\\john_doe.jpg");

    EasyMock.replay(mockFieldSet);

    // call the method under test
    PersonItem actual = fieldSetMapper.mapFieldSet(mockFieldSet);

    EasyMock.verify(mockFieldSet);

    // assert actual data by getters..
}