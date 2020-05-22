import org.glassfish.hk2.api.AnnotationLiteral;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.slf4j.Logger;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class MockedThingsControllerTest extends JerseyTest {

  private Logger logMock = mock(Logger.class);

  @Override
  protected Application configure() {
    ResourceConfig resourceConfig = new ResourceConfig(ThingsController.class);
    resourceConfig.register(new AbstractBinder() {
      @Override
      protected void configure() {
        bind(logMock).to(Logger.class);
        bind("some mocked value").to(new TypeLiteral<String>() {}).qualifiedBy(new SomeQualifierLiteral());
      }
    });
    return resourceConfig;
  }

  @Test
  public void doSomething() {
    Response response = target("/things").request().get();
    assertEquals(200, response.getStatus());
    verify(logMock).info("getting things");
  }

  static class SomeQualifierLiteral extends AnnotationLiteral<SomeQualifierInterface> implements SomeQualifierInterface {}
}