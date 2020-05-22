@RunWith( PowerMockRunner.class )
@PrepareForTest( Foo.class, Bar.class, DelegateForFoo.class )
public class BarTest

    @Test
    public void thatDelegateForFooCanBeMocked() {
        DelegateForFoo mockDelegate = EasyMock.createMock(DelegateForFoo.class);
        EasyMock.expect( mockDelegate.delegatedMethod() ).andReturn( 5 );
        EasyMock.replay( mockDelegate );

        PowerMock.expectNew( DelegateForFoo.class ).andReturn( mockDelegate );
        PowerMock.replayAll();

        Bar bar = new Bar();
        int result = bar. useDelegateForFooWithoutKnowingAboutIt();

        Assert.assertThat( result, CoreMatchers.is(15) );

        PowerMock.verifyAll();
        EasyMock.verify(mockDelegate);
    }
}