String cookie = http.getRequestProperty("Cookie");
            if (cookie != null && cookie.length() > 0)
            {
                sCookie = cookie;
                Log.v("cookie2", sCookie);
            }