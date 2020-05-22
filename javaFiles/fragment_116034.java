import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Invocation;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.action.CustomAction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class TestClass {

  Mockery context = new JUnit4Mockery();

  @Test
  public void testMethod() {
    final Foo foo = context.mock(Foo.class);

    context.checking(new Expectations() {
      {
        allowing(foo).f();
        will(new CustomAction("Returns new BusinessObj instance") {
          @Override
          public Object invoke(Invocation invocation) throws Throwable {
            return new BusinessObj();
          }
        });
      }
    });

    BusinessObj obj1 = foo.f();
    BusinessObj obj2 = foo.f();

    Assert.assertNotNull(obj1);
    Assert.assertNotNull(obj2);
    Assert.assertNotSame(obj1, obj2);
  }

  private interface Foo {
    BusinessObj f();
  }

  private static class BusinessObj {
  }
}