@RestController
public class FooController {

   @GetMapping("test/{customType}")
   public String test(@ModelAttribute CustomType customType) { ... }
}

@ControllerAdvice
public class GlobalControllerAdvice {

   @ModelAttribute("customType")
   public CustomType getCustomType(@PathVariable String customType) {
      CustomeType result = // map value to object
      return result;
   }
}