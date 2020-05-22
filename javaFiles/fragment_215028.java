if (savedCookies != null) { // savedCookies  is there in FunctionalTest class
            if (request.cookies != null) {
                request.cookies.putAll(savedCookies);
            } else {
                request.cookies = savedCookies;
            }
        }