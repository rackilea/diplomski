String encoding = "UTF-8";

httpExchange.getResponseHeaders().set("Content-Type", "text/html; charset=" + encoding);

Writer out = new OutputStreamWriter(httpExchange.getResponseBody(), encoding));
out.write(something);