Cookie[] cookies = request.getCookies();
int count = 0;
for(Cookie cookie:cookies){
    if(cookie.getName().equals("www.yourDomain.com.HitCounter")){
        count = Integer.parseInt(cookie.getValue());
        count++;
        cookie.setValue(count+"");
    }
}
if(count == 0){
    Cookie cookie = new Cookie("www.yourDomain.com.HitCounter","1");
    cookie.setMaxAge(3600*10*24);// expire in 10 days.
    response.addCookie(cookie);
}