try {
        GZIPInputStream gzip = new GZIPInputStream(bys);
        Reader decoder = new InputStreamReader(gzip, "UTF-8");
        BufferedReader buffered = new BufferedReader(decoder);
        System.out.println(buffered.readLine());
        String data = buffered.readLine();
        InputSource xml = new InputSource(new StringReader(data));
        System.out.println(xml);

    } catch (IOException e) {
        e.printStackTrace();
    }