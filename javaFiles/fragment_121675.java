try {
        URL ip = new URL("http://checkip.amazonaws.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(ip.openStream()));

        System.out.println(in.readLine());
    } catch (IOException e) {
        e.printStackTrace();
    }