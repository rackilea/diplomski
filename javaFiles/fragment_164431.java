public void authenticate(HttpServletRequest req) {
    String authhead = req.getHeader("Authorization");

        if (authhead != null) {
            // *****Decode the authorisation String*****
            byte[] e = Base64.decode(authhead.substring(6));
            String usernpass = new String(e);
            // *****Split the username from the password*****
            String user = usernpass.substring(0, usernpass.indexOf(":"));
            String password = usernpass.substring(usernpass.indexOf(":") + 1);
            // check username and password
        }
}