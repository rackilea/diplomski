public static String getCookieValue(HttpServletRequest request, String name)
    {
        boolean found = false;
        String result = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            {
                int i = 0;
                while (!found && i < cookies.length)
                    {
                        if (cookies[i].getName().equals(name))
                            {
                                found = true;
                                result = cookies[i].getValue();
                            }
                        i++;
                    }
            }
        return (result);
    }