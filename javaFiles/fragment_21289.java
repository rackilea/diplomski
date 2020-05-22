private void doServiceCall(HttpServletRequest request, StringBuilder sb) throws GSSException, MalformedURLException, PrivilegedActionException, IOException {
       if (request instanceof DelegateServletRequest) {
            DelegateServletRequest dsr = (DelegateServletRequest) request;
            GSSCredential creds = dsr.getDelegatedCredential();
            if (null == creds) {
                sb.append("No delegated creds.");
            } else {
                sb.append(creds.getName().toString());

                SpnegoHttpURLConnection spnego =
                    new SpnegoHttpURLConnection(creds);

                HttpURLConnection con = spnego.connect(new URL("https://server.domain.com/ServiceFactory/servicenamexyz/Get?KeyConditionValue=ACTION_OUTPUT"));

                sb.append("<br />HTTP Status Code: " + spnego.getResponseCode());
                sb.append("<br />HTTP Status Message: " + spnego.getResponseMessage());

                String contentType = con.getContentType();
                sb.append("<br />HTTP Content Type: " + contentType);

                StringBuilder result = new StringBuilder();
                String line;
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                reader.close();

                sb.append("<br />HTTP Content: " + result.toString());

                spnego.disconnect();
            }

        } else {
            sb.append("Request not a delegate.");
        }
       br(sb);
}