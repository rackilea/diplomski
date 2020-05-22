private void setMockB(AClass objectA, BClass mockB)
{
    Field bField = AClass.class.getDeclaredField("b");
    bField.setAccessible(true);
    bField.set(objectA, mockB)
}