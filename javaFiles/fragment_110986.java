try {
        URL url = new URL("https://ark.intel.com/");
        HttpURLConnection cnt = (HttpURLConnection) url.openConnection();
        cnt.setRequestProperty("Host", "ark.intel.com");
        cnt.setRequestProperty("Connection", "keep-alive");
        cnt.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        cnt.setRequestProperty("Accept", "text/html");

        int stat = cnt.getResponseCode();
        if (stat != 200) {
            throw new IOException("HTTP error " + stat);
        }
        BufferedReader read = new BufferedReader(new InputStreamReader(cnt.getInputStream()));
        String line;
        String data = "";

        while ((line = read.readLine()) != null) {
            data += line;
            System.out.println(line);
        } read.close();
    } catch (Exception error) {
        error.printStackTrace();
    }