InputStream in = (InputStream) context.get("requestEntity");
    if (in == null) {
        in = context.getRequest().getInputStream();
    }
    String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
    body = body.toUpperCase();
    context.set("requestEntity", new ByteArrayInputStream(body.getBytes("UTF-8")));