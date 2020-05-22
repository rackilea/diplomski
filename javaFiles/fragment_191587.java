package com.example;
import org.cactoos.io.ResourceOf;
import org.cactoos.io.TextOf;
public class FooTest {
  @Test 
  public void shouldWork() throws Exception {
    String xml = new TextOf(
      new ResourceOf("/com/example/abc.xml") // absolute path always!
    ).asString();
  }
}