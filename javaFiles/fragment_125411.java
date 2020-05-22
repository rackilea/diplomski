public class FooService { ... }

public class SomeOtherService {
     public SomeOtherService(FooService fooService) {
          this.fooService = fooService;
     }
}