@RequestMapping(value = "/login")
public String processLogin(HttpServletResponse response,
                           @RequestParam(value = "code") String code)throws IOException {

    response.reset();
    response.setContentType("text/html");
    Resource file = new ClassPathResource("/META-INF/resources/index.html");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(), UTF_8));
    htmlSourceContent = bufferedReader.lines().collect(Collectors.joining());


    //do changes with htmlSourceContent
    response.getOutputStream().write(htmlSourceContent);
    log.debug("Authentication successfully passed");
 }