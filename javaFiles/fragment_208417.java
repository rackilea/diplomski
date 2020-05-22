Map<String, Object> user = new HashMap<String, Object>() {
            {
                put("firstname", "myname");
                put("lastname", "surname");
                put("phone", new HashMap<String, String>() {
                    {
                        put("home", "123213213213");
                        put("office", "312321321312312");
                        put("mobile", "4532134213131312");
                    }
                });
            }
        };