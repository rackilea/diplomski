package de.scrum_master.app;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public class Application {
  public static void main(String[] args) {
    new Application().update("foo", 11, "bar", 22);
  }

  @MyAnnotation
  public Response update(
    @PathParam("pathParam") String p1,
    @PathParam("pathParam2") @MyAnnotation int p2,
    @MyAnnotation String text,
    int number
  ) {
    return null;
  }
}