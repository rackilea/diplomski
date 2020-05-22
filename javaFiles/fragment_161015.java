Map<String, String> cookies;
Map<String, String> data = new HashMap<String, String>();

Connection.Response loginPageRes = Jsoup.connect(loginFormUrl)
    .userAgent(userAgent)
    .referrer(refferer)
    .timeout(30 * 1000)
    .method(Connection.Method.GET)
    .followRedirects(true)
    .execute();

cookies = loginPageRes.cookies();

data.put(usernameKey, username);
data.put(passwordKey, password);
data.put("remember_me", "1");
data.put("wfa", "1");
data.put("redirect_after_login", "/");
data.put("commit", " Log in ");
data.put("authenticity_token", loginPageRes.parse().select("input[name=authenticity_token]").val());

Connection.Response resPostLogin = Jsoup.connect(loginActionUrl)
    .method(Connection.Method.POST)
    .userAgent(userAgent)
    .referrer(loginFormUrl)
    .data(data)
    .cookies(cookies)
    .timeout(30 * 1000)
    .followRedirects(true)
    .execute();

doc = resPostLogin.parse();
    String timelineText = doc.text();