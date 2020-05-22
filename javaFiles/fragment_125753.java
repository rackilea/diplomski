@Test
public void thatMoneyAddedIsNotAltered(){
    Money mockMoney = EasyMock.createMock(Money.class);
    EasyMock.expect( mockMoney.getCurrency() ).andReturn( "EUR" );
    EasyMock.expect( mockMoney.getAmount() ).andReturn( 3.0 );
    EasyMock.replay(mockMoney);

    Money realMoney = new Money();
    realMoney.addMoney( mockMoney );

    EasyMock.verify( mockMoney );
}