package de.scrum_master.app;

import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

public class Application {
  @GetMapping public void get() {}
  @PostMapping(value = "foo") public void post() {}
  @RequestMapping(value = {"foo", "bar"}, method = HEAD) public void head() {}
  @RequestMapping(value = "foo", method = OPTIONS) public void options() {}
  @PutMapping(value = "foo") public void put() {}
  @PatchMapping(value = "foo") public void patch() {}
  @DeleteMapping(value = {"foo", "bar"}) @Deprecated public void delete() {}
  @RequestMapping(value = "foo", method = TRACE) public void trace() {}
  @RequestMapping(value = "foo", method = { GET, POST, HEAD}) public void mixed() {}

  public static void main(String[] args) {
    Application application = new Application();
    application.get();
    application.post();
    application.head();
    application.options();
    application.put();
    application.patch();
    application.delete();
    application.trace();
    application.mixed();
  }
}