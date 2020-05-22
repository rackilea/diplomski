import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.powermock.api.mockito.PowerMockito;
    import org.powermock.core.classloader.annotations.PrepareForTest;
    import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
    import org.powermock.modules.junit4.PowerMockRunner;
    @RunWith(PowerMockRunner.class)
    @PrepareForTest(StaticInitializerService.class)
    @SuppressStaticInitializationFor("PackageName.StaticInitializerService")
    public class StaticInitializerServiceTest {
    @Test 
    public void method() {
    PowerMockito.mockStatic(StaticInitializerService.class);
    }   
  }