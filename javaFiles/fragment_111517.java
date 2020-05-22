messageStream.map(new MapFunction<ObjectNode, String>() {
        private static final long serialVersionUID = -6867736771747690202L;

        @Override
        public String map(ObjectNode node) throws Exception {
            return "Kafka and Flink says: " + node.get(0);
        }
    });