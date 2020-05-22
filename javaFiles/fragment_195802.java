@GetMapping(value= "/method")
public String exampleForMethodPreAuthorize() {
    if(context.getBean(MyController.class).methodController()){
        return "forMethodPreAuthorize";
    }
    else return null;
}