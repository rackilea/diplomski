@Bean
LineMapper<List<Engine>> lineMapper() {
    return new LineMapper<List<Engine>>() {
        @Override
        public <List<Engine>> mapLine(String line, int lineNum) throws Exception {
            String[] tokens = line.split(";");
            if (tokens.length < 1) {
                throw new DataIntegrityViolationException("Expecting at least one token in input line: " + line);
            }
            List<Engine> data = new ArrayList<Engine>;
            for (String token : tokens) {
                data.add(Engine.of(token));
            }
            return data;
        }
    };
}