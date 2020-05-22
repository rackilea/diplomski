package org.my;

@RunWith(SpringJUnit4ClassRunner.class)
public class ChildTest extends BaseTest {

    @Inject
    private Foo myFoo;

    @Test
    public void myTest() {
          ...
    }
}