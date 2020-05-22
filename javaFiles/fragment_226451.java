try (FileInputStream fis = new FileInputStream("D:/temp/tokens.json")) {
        JsonFactory jf = new JsonFactory();
        JsonParser jp = jf.createParser(fis);
        jp.setCodec(new ObjectMapper());
        jp.nextToken();
        while (jp.hasCurrentToken()) {
            Token token = jp.readValueAs(Token.class);
            jp.nextToken();
            System.out.println("Token serial "+token.getSerialNumber());
        }
    }