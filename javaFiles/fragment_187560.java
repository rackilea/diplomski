package de.scrum_master.app;

import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

public class Application {
  @GetMapping public void get() {}
  @PostMapping public void post() {}
  @RequestMapping(method = HEAD) public void head() {}
  @RequestMapping(method = OPTIONS) public void options() {}
  @PutMapping public void put() {}
  @PatchMapping public void patch() {}
  @DeleteMapping @Deprecated public void delete() {}
  @RequestMapping(method = TRACE) public void trace() {}
  @RequestMapping(method = { GET, POST, HEAD}) public void mixed() {}

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