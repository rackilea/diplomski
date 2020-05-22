String encoding = "UTF-8";
    String ret = jsonArr.toString();
    he.getResponseHeaders().set("Content-Type", "application/json; charset=" + encoding);

    //ret= URLDecoder.decode(ret, "UTF-8");
    byte[] bytes = ret.getBytes(StandardCharsets.UTF_8);
    he.sendResponseHeaders(200, bytes.length);
    System.out.println(ret);
    OutputStream os = he.getResponseBody();
    os.write(bytes);
    os.close();