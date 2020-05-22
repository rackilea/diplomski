URLConnection cnt = url.openConnection();
        InputStream stream = cnt.getInputStream();
        if ("gzip".equalsIgnoreCase(cnt.getHeaderField("Content-Encoding"))) {
            stream = new GZIPInputStream(stream);
        }
        BufferedReader read = new BufferedReader(new InputStreamReader(stream, "UTF-8"));