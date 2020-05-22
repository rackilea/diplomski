@Override
protected Map<String, Response> mapResponseMessages(Set<ResponseMessage> from) {
    Map<String, Response> responses = super.mapResponseMessages(from);
    responses.forEach((key, response)-> {
        Map<String, Object> examples = response.getExamples();
        examples.entrySet().forEach(example -> {
            Object exampleObject = example.getValue();
            if (exampleObject instanceof String) {
                String exampleValue = (String) exampleObject;
                if (exampleValue.startsWith("file:")) {
                    String fileContent = readFileContent(exampleValue);
                    example.setValue(fileContent);
                }
            }});
    });

    return responses;
}

private String readFileContent(String example) {
    String fileContent = "";
    try {
        String fileName = example.replace("file:", "");
        File resource = new ClassPathResource(fileName).getFile();
        if(resource.exists()) {
            fileContent
                    = new String(Files.readAllBytes(resource.toPath()));
        }
    } catch (
            IOException e) {
        log.error("Cannot read swagger documentation from file {}", example);
    }
    return fileContent;
}