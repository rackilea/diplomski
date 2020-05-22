@GetMapping(value = "/login/returnFromFacebook")
  public String getFacebookData(@RequestParam("code") String authorizationCode, HttpServletResponse httpServletResponse) throws IOException {
    System.out.println(authorizationCode);
       ResponseEntity response = this.restTemplate.getForEntity(this.serverApi +
         "/login/returnFromFacebook?code=" + authorizationCode, ResponseEntity.class);
    System.out.println(response.getStatusCodeValue() + " " + response.getHeaders().get("Location"));

    //set cookie for original request
    String jwtCookieHeader = String.valueOf(response.getHeaders().get("set-cookie"));
    jwtCookieHeader = jwtCookieHeader.substring(1,jwtCookieHeader.length()-1);

    httpServletResponse.setHeader("set-cookie", jwtCookieHeader);
       if(response.getStatusCode().is2xxSuccessful()){
         return "redirect:/";
       }
           return String.valueOf(new ResponseEntity(HttpStatus.CONFLICT));
  }