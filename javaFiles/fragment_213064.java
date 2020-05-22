import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class MyClassTest {

  @Test
  public void test() {
    // Create a partial mock by calling its constructor
    // and only mocking getSize
    MyClass mock = createMockBuilder(MyClass.class)
        .withConstructor(true, true)
        .addMockedMethod("getSize")
        .createMock();

    // Record that getSize should return 8 (instead of 42)
    expect(mock.getSize()).andReturn(8);

    // All recording done. So put the mock in replay mode
    replay(mock);

    // Then, these assertions are to prove that the partial mock is 
    // actually doing what we expect. This is just to prove my point. Your
    // actual code will verify that myMethod is doing was is expected

    // 1. Verify that the constructor was correctly called
    assertEquals(true, mock.getB1());
    assertEquals(true, mock.getB2());
    // 2. Verify that getSize was indeed mocked 
    assertEquals(8, mock.myMethod());

    // Check everything expected was indeed called
    verify(mock);
  }
}