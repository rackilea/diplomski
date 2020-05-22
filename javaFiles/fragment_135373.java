private OperationPreprocessor removeCompany() {
    return new ContentModifyingOperationPreprocessor(new ContentModifier() {

        @Override
        public byte[] modifyContent(byte[] originalContent, MediaType contentType) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Map<?, ?> map = objectMapper.readValue(originalContent, Map.class);
                map.remove("companyName");
                return objectMapper.writeValueAsBytes(map);
            }
            catch (IOException ex) {
                return originalContent;
            }
        }

    });
}