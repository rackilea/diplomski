static class CustomDeserializer extends JsonDeserializer<List<MyRecord>> {

        @Override
        public List<MyRecord> deserialize(String topic, Headers headers, byte[] data) {
            return deserialize(topic, data);
        }

        @Override
        public List<MyRecord> deserialize(String topic, byte[] data) {
            if (data == null) {
                return null;
            }
            try {
                return objectMapper.readValue(data, new TypeReference<List<MyRecord>>() {
                });
            } catch (IOException e) {
                throw new SerializationException("Can't deserialize data [" + Arrays.toString(data) +
                        "] from topic [" + topic + "]", e);
            }
        }
    }