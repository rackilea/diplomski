// Authentication part -------------------
        String userpass = email_adress + ":" + password;
        conn.setRequestProperty("X-Requested-With", "Curl");
        String basicAuth = "Basic " + new String(android.util.Base64.encode(userpass.getBytes(), android.util.Base64.DEFAULT));
        conn.setRequestProperty("Authorization", basicAuth);
        // ----------------------------------------