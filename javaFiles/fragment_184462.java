protected QueryResponse getResponse(String fileName) throws IOException {

        Path path = Paths.get(resDir + "/" + fileName);
        InputStream body= new FileInputStream(path.toFile());
        NamedList<Object> result= processResponse(body, null);
        QueryResponse response = new QueryResponse();
        response.setResponse(result);
        return response;
    }

    private NamedList<Object> processResponse(InputStream body, Object o) {
        XMLResponseParser parser= new XMLResponseParser();
        NamedList<Object> result= parser.processResponse(body, "UTF-8");
        return result;
    }