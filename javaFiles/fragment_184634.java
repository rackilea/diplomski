// AjaxResult.java
public class AjaxResult {
    private int answer;
    private String errMsg;

   // Getters/setters for both properties.
}

// Inside MyController.java (a Spring @Controller):
 @RequestMapping( value="/myController", method= RequestMethod.GET, produces = "application/json")
 public @ResponseBody AjaxResult handleJQueryCall(@RequestParam("x") String whatever) {
   int ans = calculateSomething(whatever);

AjaxResult result = new AjaxResult(ans);

return result;
}