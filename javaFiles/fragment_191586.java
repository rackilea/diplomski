package com.example;
import org.apache.commons.io.IOUtils;
public class FooTest {
  @Test 
  public void shouldWork() throws Exception {
    String xml = IOUtils.toString(
      this.getClass().getResourceAsStream("abc.xml"),
      "UTF-8"
    );
  }
}