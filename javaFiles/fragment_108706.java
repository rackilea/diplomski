List<NameValuePair> pairs = new ArrayList<NameValuePair>();
pairs.add(new BasicNameValuePair("content-type", "application/json"));
StringEntity input = new StringEntity("{\"Defect\":{\"Name\":\"my new defect\"}}");
input.setContentType("application/json");
createDefect.setEntity(input);
for (NameValuePair h : pairs)
    {
        createDefect.addHeader(h.getName(), h.getValue());
    }
HttpResponse resp = httpClient.execute(createDefect);