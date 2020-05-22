String cookieTarget = null;
    for (final Cookie cookie : this.kSupTestCase.getDriver().manage().getCookies()) {
        if (StringUtils.equalsIgnoreCase(cookie.getName(), "JSESSIONID")) {
            cookieTarget = cookie.getName() + "=" + cookie.getValue();
            break;
        }
    }