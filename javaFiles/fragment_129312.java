public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("/home/user/test.json");

        // step 1 – assuming you already habe or wrote a file with empty JSON list []
        List<Test> tests = mapper.readValue(file, new TypeReference<List<Test>>(){});

        // step 2
        tests.add(new Test(4));

        // step 3
        mapper.writeValue(file, tests);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Test {
        int a;
    }