private Page readPage(Integer offset, String filename) {
        try (Reader in = new FileReader(filename)) {
            in.skip(offset);
            ObjectMapper mapper = new XmlMapper();
             mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Page object = mapper.readValue(in, Page.class);
            return object;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }