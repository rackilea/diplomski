http://localhost:8080/changeCSS?color1=green&color2=red

@RequestMapping(value = "/changeCSS", method = RequestMethod.GET)
public String changeCss(@RequestParam("color1") String color1, @RequestParam("color2") String color2) {


     ....

}