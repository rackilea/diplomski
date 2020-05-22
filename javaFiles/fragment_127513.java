URLConnection connection = new URL(driver.getCurrentUrl()).openConnection();

for (Cookie cookie : driver.manage().getCookies()) {
    String cookieHeader = cookie.getName() + "=" + cookie.getValue();
    connection.addRequestProperty("Cookie", cookieHeader);
}

InputStream input = connection.getInputStream(); // Write this to file.