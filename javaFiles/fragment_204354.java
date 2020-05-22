try (WebClient webClient = new WebClient()) {
    while (true) {
        try {
            int status = webClient.getPage("http://localhost/test.html").getWebResponse().getStatusCode();
            System.out.println(new Date() + " " + status);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        Thread.sleep(1000);
    }
}