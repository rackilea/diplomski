public void end(HttpExchange t, String response, long tStart, int status) throws IOException {
        try {
            String temp = convertToUTF8(response);
            t.sendResponseHeaders(status, temp.length());
            OutputStream os = t.getResponseBody();
            OutputStream bout= new BufferedOutputStream(os);
            OutputStreamWriter out = new OutputStreamWriter(bout, "UTF-8");
            out.write(response);
            out.flush();
            out.close();
        }catch (UnsupportedEncodingException e) {
            System.out.println("This VM does not support the UTF-8 character set.");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        System.out.println("Done handling request! Time took: " + tDelta);
    }