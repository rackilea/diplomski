public class testAbc extends abc {
public testAbc()
{super("x","y");}
@Override
public Object fun(String a){
Object x = super.fun(a);
}

@Test
public void testFun()
{
TestAbc t = new TestAbc();
t.fun("testString");
}


}