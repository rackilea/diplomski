Cookie cookie1 = Cookie.Builder("JSESSIONID", "B1FAC334FF60F7182D4C552ABE01A700").build();
Cookie cookie2 = Cookie.Builder("hi.session.co.entity", "1838-PROD1").build();
Cookie cookie3 = Cookie.Builder("hi.session.id.identifier", "xHmvClBuIBcSKAEiVP~~AAAESADWaUjq").build();
Cookie cookie4 = Cookie.Builder("hi.session.client.identifier", "1838Viewer").build();
Cookies cookies = new Cookies(cookie1, cookie2, cookie3, cookie4);

given().cookies(cookies)
       .when().get("/hi-prod/3.1.12/al/api/articles")