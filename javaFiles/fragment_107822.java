HttpPost post = new HttpPost(...);

ArrayList<String> authPrefs = new ArrayList<String>();
authPrefs.add(AuthSchemes.NTLM);
authPrefs.add(AuthSchemes.KERBEROS);

// ...

RequestConfig config = RequestConfig.custom()
        .setProxyPreferredAuthSchemes(authPrefs).build();
post.setConfig(config);

// ....

client.execute(post);