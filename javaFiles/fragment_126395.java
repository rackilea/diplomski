public String cookieElement(String Url,String CookieName){
    String CookieValue = null;

    CookieManager cookieManager = CookieManager.getInstance();
    String cookies = cookieManager.getCookie(Url);
    String[] temp=cookies.split(";");
    for (String ar1 : temp ){
        if(ar1.contains(CookieName)){
            String[] temp1=ar1.split("=");
            CookieValue = temp1[1];
            break;
        }
    }
    return CookieValue;
}