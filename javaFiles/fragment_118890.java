for (String cookieStr : request.headers().get("Cookie")) {
    String name = cookieStr.substring(0, cookieStr.indexOf("="));

    Logger.info("Name of the cookie : " + name);

    Cookie cookie = request.cookie(name); // Get the instance of the cookie !
}