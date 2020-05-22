try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
    String input;
    while ((input = br.readLine()) != null) {
        SomeRequest req = new SomeRequest();
        req.text = input;
        client.sendTCP(req);
        }
    }
    System.out.print("End of input");
}