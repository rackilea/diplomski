public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        InputStream is = context.getInputStream();
        String body = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        ObjectMapper mapper = new ObjectMapper();
        try {
            SampleObject sampleObject = mapper.readValue(body, SampleObject.class);
            LOGGER.info(sampleObject.getSampleProperty());

        } catch (JsonGenerationException | JsonMappingException e) {
            LOGGER.info(e.getMessage());
        }
        InputStream in = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));

        context.setInputStream(in)
        return context.proceed();
    }