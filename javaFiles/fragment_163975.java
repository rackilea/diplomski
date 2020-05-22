for (int index = 0; index < boxCookies.size(); index++){
            String cookie = boxCookies.toArray()[index].toString();
            String cookieNameValue =cookie.substring(0, cookie.indexOf(";"));
            String name = cookieNameValue.substring(0, cookieNameValue.indexOf("="));
            String value = cookieNameValue.substring(cookieNameValue.indexOf("=") + 1);

            if (index == 0){
                cookieHeader.append(name + "=" +value);
            } else {
                cookieHeader.append("; "+ name + "=" +value);
            }

        }
        WebRequest secondLoginPage = new WebRequest(AUTHORIZE_URL);
        secondLoginPage.setAdditionalHeader("Cookie", cookieHeader.toString());
        HtmlPage loginPage2 = webClient.getPage(secondLoginPage);