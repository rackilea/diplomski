@RequestMapping("/addAddress/**")
public String addAddress(HttpServletRequest request) {
    String fullUrl = request.getRequestURL().toString();
    String url = fullUrl.split("/addAddress/")[1];
    System.out.println(url);
    return url;
}