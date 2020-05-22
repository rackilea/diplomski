LoginContext lc = null;
        String username = "UseR_U";
        String password = "hashedpassword";
        UsernamePasswordHandler handler = new UsernamePasswordHandler(username,
                password == null ? null : password.toCharArray());
        lc = new LoginContext("targin-client", handler);
        lc.login();