/**
 * Validates Google reCAPTCHA V2 or Invisible reCAPTCHA.
 *
 * @param secretKey Secret key (key given for communication between your
 * site and Google)
 * @param response reCAPTCHA response from client side.
 * (g-recaptcha-response)
 * @return true if validation successful, false otherwise.
 */
public synchronized boolean isCaptchaValid(String secretKey, String response) {
    try {
        String url = "https://www.google.com/recaptcha/api/siteverify",
                params = "secret=" + secretKey + "&response=" + response;

        HttpURLConnection http = (HttpURLConnection) new URL(url).openConnection();
        http.setDoOutput(true);
        http.setRequestMethod("POST");
        http.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");
        OutputStream out = http.getOutputStream();
        out.write(params.getBytes("UTF-8"));
        out.flush();
        out.close();

        InputStream res = http.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(res, "UTF-8"));

        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        JSONObject json = new JSONObject(sb.toString());
        res.close();

        return json.getBoolean("success");
    } catch (Exception e) {
        //e.printStackTrace();
    }
    return false;
}