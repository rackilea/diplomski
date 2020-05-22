@RequestMapping(value="/btwn/{min}/{max}", method = RequestMethod.GET)
public String btwn(@PathVariable() int min,@PathVariable() int max){

    // IF max == 0 ? true:false;
    max = max == 0 ? 100:max;

    List<Product> productsBtwn = productService.findProductsBetween(min, max);

    return "jspFile";
}