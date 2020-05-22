@Test
public void testAll() {
    String res = StringExample.firstFunction();
    Assert.assertEquals("msg1", res);

    res = StringExample.secondFunction(res);
    Assert.assertEquals("msg1msg2", res);

    res = StringExample.thirdFunction(res);
    Assert.assertEquals("msg1msg2msg3", res);
}