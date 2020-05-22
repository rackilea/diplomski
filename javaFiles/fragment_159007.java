@RequestMapping(value = "/", headers = "Accept=application/json")
@ResponseBody
String request(@RequestHeader HttpHeaders headers){
    for(MediaType mediaType : headers.getAccept()){
        if(mediaType.isCompatibleWith(MediaType.APPLICATION_JSON)){
            if(mediaType.getParameter("version").startsWith("1.")){
                return v1();
            }else if(mediaType.getParameter("version").startsWith("2.")){
                return v2();
            }
        }
    }
    return "error";
}