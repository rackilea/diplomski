private Tuple2<String, HashMap> map3(Tuple2<String, HashMap> inputTuple) {
        String input = inputTuple.getT1();
        HashMap context = inputTuple.getT2();
        // mapping example
        String result = input + context.get("result1") +  "mappingExample";
        context.put("result3", result);
        return Tuples.of(result, context);
    }